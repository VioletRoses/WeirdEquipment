package xyz.venividivivi.weirdequipment.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import xyz.venividivivi.weirdequipment.block.WallRopeBlock;
import xyz.venividivivi.weirdequipment.item.RopeCoilItem;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentBlocks;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentEntityTypes;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentItems;

public class RopeCoilEntity extends ThrownItemEntity {
    public boolean isPlacing = false;
    private BlockPos blockPos = null;
    private int i = 0, count = 0;
    private static final TrackedData<ItemStack> STACK = DataTracker.registerData(RopeCoilEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);

    public RopeCoilEntity(World world, LivingEntity owner, RopeCoilItem item) {
        super(WeirdEquipmentEntityTypes.ROPE_COIL, owner, world);
        count = item.count;
        getDataTracker().startTracking(STACK, new ItemStack(item, 1));
        this.world = world;
    }

    public RopeCoilEntity(EntityType<RopeCoilEntity> ropeCoilEntityEntityType, World world) {
        super(ropeCoilEntityEntityType, world);
        getDataTracker().startTracking(STACK, new ItemStack(WeirdEquipmentItems.SMALL_ROPE_COIL, 1));
    }


    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!isPlacing) {
            Direction side = blockHitResult.getSide();
            blockPos = blockHitResult.getBlockPos().offset(side);
            if (world.getBlockState(blockPos).isAir() && side != Direction.UP) {
                switch (side) {
                    case NORTH, EAST, WEST, SOUTH:
                        BlockState blockState = WeirdEquipmentBlocks.WALL_ROPE.getDefaultState().with(WallRopeBlock.FACING, side.getOpposite());
                        if (WeirdEquipmentBlocks.WALL_ROPE.canPlaceAt(blockState, world, blockPos)) {
                            world.setBlockState(blockPos, blockState);
                        } else dropItem();
                        break;
                    case DOWN:
                        if (WeirdEquipmentBlocks.ROPE.canPlaceAt(WeirdEquipmentBlocks.ROPE.getDefaultState(), world, blockPos)) {
                            world.setBlockState(blockPos, WeirdEquipmentBlocks.ROPE.getDefaultState());
                        } else dropItem();
                        break;
                }
                this.setNoGravity(true);
                this.setVelocity(0, 0, 0, 0f, 0f);
                count--;
                isPlacing = true;
            } else dropItem();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), getDataTracker().get(STACK)));
        remove(RemovalReason.DISCARDED);
    }

    @Override
    public void tick() {
        if (i == 2) {
            i = 0;
            if (isPlacing && blockPos != null) {
                if (world.getBlockState(blockPos = blockPos.offset(Direction.DOWN)).isAir() && count > 0) {
                    world.setBlockState(blockPos, WeirdEquipmentBlocks.ROPE.getDefaultState());
                    count--;
                } else if (count > 0) {
                    world.spawnEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY() + 1.5, blockPos.getZ(), new ItemStack(WeirdEquipmentItems.ROPE, count)));
                    remove(RemovalReason.DISCARDED);
                } else {
                    remove(RemovalReason.DISCARDED);
                }
            }
        } else i++;
        super.tick();
    }

    public void dropItem() {
        world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), getDataTracker().get(STACK)));
        remove(RemovalReason.DISCARDED);
    }
    @Override
    protected Item getDefaultItem() {
        return getDataTracker().get(STACK).getItem();
    }
}

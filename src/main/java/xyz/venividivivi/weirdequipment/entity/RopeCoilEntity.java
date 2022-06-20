package xyz.venividivivi.weirdequipment.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentEntityTypes;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentItems;

public class RopeCoilEntity extends ThrownItemEntity {
    public World world;
    public boolean isPlacing = false;
    BlockPos blockPos = null;
    int i = 0, j = 1;

    public RopeCoilEntity(World world, LivingEntity owner) {
        super(WeirdEquipmentEntityTypes.ROPE_COIL, owner, world);
        this.world = world;
    }

    public RopeCoilEntity(EntityType<RopeCoilEntity> ropeCoilEntityEntityType, World world) {
        super(ropeCoilEntityEntityType, world);
        this.world = world;
    }


    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!isPlacing) {
            Direction side = blockHitResult.getSide();
            blockPos = blockHitResult.getBlockPos().offset(side);
            if (world.getBlockState(blockPos).isAir() && side != Direction.UP) {
                world.setBlockState(blockPos, Blocks.OAK_FENCE.getDefaultState());
                this.setNoGravity(true);
                this.setVelocity(0, 0, 0, 0f, 0f);
                isPlacing = true;
            } else {
                world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(WeirdEquipmentItems.ROPE_COIL, 1)));
                remove(RemovalReason.DISCARDED);
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(WeirdEquipmentItems.ROPE_COIL, 1)));
        remove(RemovalReason.DISCARDED);
    }

    @Override
    public void tick() {
        if (i == 3) {
            i = 0;
            if (isPlacing && blockPos != null) {
                if (world.getBlockState(blockPos = blockPos.offset(Direction.DOWN)).isAir() && j <= 18) {
                    world.setBlockState(blockPos, Blocks.OAK_FENCE.getDefaultState());
                    j++;
                } else {
                    remove(RemovalReason.DISCARDED);
                }
            }
        } else i++;
        super.tick();
    }

    @Override
    protected Item getDefaultItem() {
        return WeirdEquipmentItems.ROPE_COIL;
    }
}
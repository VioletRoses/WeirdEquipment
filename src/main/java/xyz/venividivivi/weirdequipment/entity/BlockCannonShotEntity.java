package xyz.venividivivi.weirdequipment.entity;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentEntityTypes;

public class BlockCannonShotEntity extends ThrownItemEntity {
    public static final TrackedData<ItemStack> STACK = DataTracker.registerData(BlockCannonShotEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);
    public BlockCannonShotEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
        getDataTracker().startTracking(STACK, new ItemStack(Items.AIR, 1));
    }

    public BlockCannonShotEntity(World world, LivingEntity owner, Item block) {
        super(WeirdEquipmentEntityTypes.BLOCK_CANNON_SHOT, owner, world);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.3, owner.getZ());
        getDataTracker().startTracking(STACK, new ItemStack(block, 1));
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        Item item = getDataTracker().get(STACK).getItem();
        Block block = Blocks.AIR;
        if (item instanceof BlockItem) {
            block = ((BlockItem) item).getBlock();
        }
        if(!world.isClient()) {
            Direction side = blockHitResult.getSide();
            BlockPos blockPos = blockHitResult.getBlockPos().offset(side);
            if (world.getBlockState(blockPos).isAir() && block.canPlaceAt(block.getDefaultState(), world, blockPos)) {
                world.setBlockState(blockPos, block.getDefaultState());
                remove(RemovalReason.DISCARDED);
            } else {
                world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(block.asItem(), 1)));
                remove(RemovalReason.DISCARDED);
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), getDataTracker().get(STACK)));
        remove(RemovalReason.DISCARDED);
    }

    @Override
    protected Item getDefaultItem() {
        return getDataTracker().get(STACK).getItem();
    }
}

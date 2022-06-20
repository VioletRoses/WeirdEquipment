package xyz.venividivivi.weirdequipment.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentItems;

public class RopeCoilEntity extends ThrownItemEntity {
    public World world;
    public RopeCoilEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
        this.world = world;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(WeirdEquipmentItems.ROPE_COIL, 1)));
        remove(RemovalReason.DISCARDED);
    }

    @Override
    protected Item getDefaultItem() {
        return WeirdEquipmentItems.ROPE_COIL;
    }
}

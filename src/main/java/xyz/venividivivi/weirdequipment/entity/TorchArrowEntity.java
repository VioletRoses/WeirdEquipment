package xyz.venividivivi.weirdequipment.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentEntityTypes;

public class TorchArrowEntity extends PersistentProjectileEntity {

    public World world;
    public PlayerEntity playerEntity;
    public int fireTime = 3;

    public TorchArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
        this.world = world;
    }

    public TorchArrowEntity(World world, LivingEntity owner) {
        super(WeirdEquipmentEntityTypes.TORCH_ARROW, owner, world);
        this.world = world;
        playerEntity = (PlayerEntity) owner;
    }


    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        Direction side = blockHitResult.getSide();
        BlockPos blockPos = blockHitResult.getBlockPos().offset(side);
        BlockState blockState;
        Block block;
        switch(side) {
            case NORTH, EAST, SOUTH, WEST:
                block = Blocks.WALL_TORCH;
                blockState = block.getDefaultState().with(WallTorchBlock.FACING, side);
                break;
            default:
                block = Blocks.TORCH;
                blockState = block.getDefaultState();
                if (!Blocks.TORCH.canPlaceAt(blockState, world, blockPos)) {
                    blockState = Blocks.TORCH.getDefaultState();
                }
        }
        if (block.canPlaceAt(blockState, world, blockPos)) {
            world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.9f);
            world.setBlockState(blockPos, blockState);
            world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
        } else {
            world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(Items.TORCH, 1)));
        }
        remove(RemovalReason.DISCARDED);
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.TORCH);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        if (entityHitResult.getEntity() instanceof LivingEntity) {
            entity.setOnFire(true);
            entity.setOnFireFor(fireTime);
            entity.damage(DamageSource.arrow(this, this.getOwner()), (float) getDamage());
        } else world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(Items.TORCH, 1)));
        remove(RemovalReason.DISCARDED);
    }
}

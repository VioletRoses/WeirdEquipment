package xyz.venividivivi.weirdequipment.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
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

public class TorchArrowEntity extends ArrowEntity {

    public World world;
    public PlayerEntity playerEntity;

    public TorchArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
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
    protected void onEntityHit(EntityHitResult entityHitResult) {
        world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(Items.TORCH, 1)));
        remove(RemovalReason.DISCARDED);
    }
}

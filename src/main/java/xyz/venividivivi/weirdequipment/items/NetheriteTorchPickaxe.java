package xyz.venividivivi.weirdequipment.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class NetheriteTorchPickaxe extends PickaxeItem {
    public NetheriteTorchPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Direction side = context.getSide();
        BlockPos blockPos = context.getBlockPos().offset(side);
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
                PlayerEntity playerEntity = context.getPlayer();
                world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.9f);
                world.setBlockState(blockPos, blockState);
                world.emitGameEvent(playerEntity, GameEvent.BLOCK_CHANGE, blockPos);
                if (playerEntity instanceof ServerPlayerEntity) {
                    context.getStack().damage(5, playerEntity, (p) -> {
                        p.sendToolBreakStatus(context.getHand());
                    });
                }
                return ActionResult.SUCCESS;
            }
        return super.useOnBlock(context);
    }
}

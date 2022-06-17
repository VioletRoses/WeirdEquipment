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
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class NetheriteTorchPickaxe extends PickaxeItem {
    public NetheriteTorchPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos().offset(context.getSide());
        BlockState blockState = null;
        Block block = null;
            switch(context.getSide()) {
                case NORTH, EAST, SOUTH, WEST:
                    block = Blocks.WALL_TORCH;
                    blockState = block.getDefaultState().with(WallTorchBlock.FACING, context.getSide());
                    break;
                default:
                    block = Blocks.TORCH;
                    blockState = block.getDefaultState();
                    if (!Blocks.TORCH.canPlaceAt(blockState, world, blockPos)) {
                        blockState = Blocks.TORCH.getDefaultState();
                    }
            }
            if (block.canPlaceAt(blockState, world, blockPos)) {
                world.setBlockState(blockPos, blockState);
                PlayerEntity playerEntity = context.getPlayer();
                if (playerEntity instanceof ServerPlayerEntity) {
                    context.getStack().damage(5, playerEntity, (p) -> {
                        p.sendToolBreakStatus(context.getHand());
                    });
                }
                return ActionResult.PASS;
            }
        return super.useOnBlock(context);
    }
}

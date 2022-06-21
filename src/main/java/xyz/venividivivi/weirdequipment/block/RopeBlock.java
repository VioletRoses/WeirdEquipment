package xyz.venividivivi.weirdequipment.block;

import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentBlocks;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentItems;

public class RopeBlock extends Block {
    public RopeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        System.out.println(world.getBlockState(pos).getBlock());
        BlockPos blockPos = pos;
        while(world.getBlockState(blockPos = blockPos.offset(Direction.UP)).getBlock() instanceof RopeBlock) {
            System.out.println("goin up");
        }
        blockPos = blockPos.offset(Direction.DOWN);
        BlockState blockState = world.getBlockState(blockPos);
        if (!world.getBlockState(blockPos.offset(Direction.UP)).isSideSolid(world, blockPos.offset(Direction.UP), Direction.DOWN, SideShapeType.CENTER)) {
            world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
            world.spawnEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(WeirdEquipmentBlocks.ROPE, 1)));
        }
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.425f, 0f, 0.425f, 0.575f, 1.0f, 0.575f);
    }
}

package xyz.venividivivi.weirdequipment.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class WallRopeBlock extends HorizontalFacingBlock {
    public WallRopeBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isSideSolidFullSquare(world, blockPos, direction);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape1 = VoxelShapes.cuboid(0.425f, 0f, 0.425f, 0.575f, 0.5f, 0.575f);
        VoxelShape shape2 = VoxelShapes.cuboid(0.425f, 0.425f, 0f, 0.575f, 0.575f, 0.575f);
        switch(state.get(FACING)) {
            case NORTH -> shape2 = VoxelShapes.cuboid(0.425f, 0.425f, 0f, 0.575f, 0.575f, 0.575f);
            case EAST -> shape2 = VoxelShapes.cuboid(0.425f, 0.425f, 0.425f, 1f, 0.575f, 0.575f);
            case SOUTH -> shape2 = VoxelShapes.cuboid(0.425f, 0.425f, 0.425f, 0.575f, 0.575f, 1f);
            case WEST -> shape2 = VoxelShapes.cuboid(0f, 0.425f, 0.425f, 0.575f, 0.575f, 0.575f);
        }
        return VoxelShapes.combine(shape1, shape2, BooleanBiFunction.OR);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }
}

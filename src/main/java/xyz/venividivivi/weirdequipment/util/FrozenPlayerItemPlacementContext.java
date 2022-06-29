package xyz.venividivivi.weirdequipment.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FrozenPlayerItemPlacementContext extends ItemPlacementContext {

    public Direction horizontalFacing, verticalFacing;
    public Direction[] facing;

    public FrozenPlayerItemPlacementContext(World world, @Nullable PlayerEntity playerEntity, Hand hand, ItemStack itemStack, BlockHitResult blockHitResult, Direction[] facing) {
        super(world, playerEntity, hand, itemStack, blockHitResult);
        this.facing = facing;
        horizontalFacing = playerEntity.getHorizontalFacing();
        verticalFacing = Direction.getLookDirectionForAxis(this.getPlayer(), Direction.Axis.Y);
    }

    @Override
    public Direction getPlayerFacing() {
        return horizontalFacing;
    }

    @Override
    public Direction[] getPlacementDirections() {
        Direction[] directions = facing;
        if (this.canReplaceExisting) {
            return directions;
        } else {
            Direction direction = this.getSide();

            int i;
            for(i = 0; i < directions.length && directions[i] != direction.getOpposite(); ++i) {
            }

            if (i > 0) {
                System.arraycopy(directions, 0, directions, 1, i);
                directions[0] = direction.getOpposite();
            }

            return directions;
        }
    }

    @Override
    public Direction getVerticalPlayerLookDirection() {
        return verticalFacing;
    }

    @Override
    public Direction getPlayerLookDirection() {
        return facing[0];
    }
}

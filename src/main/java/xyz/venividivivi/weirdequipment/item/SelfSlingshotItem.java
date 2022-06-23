package xyz.venividivivi.weirdequipment.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SelfSlingshotItem extends BowItem {
    public SelfSlingshotItem(Settings settings) {
        super(settings);
    }

    public ItemStack torchStack = null;
    public Random random = Random.create();

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            float f = getPullProgress(i);
            if (!((double) f < 0.1)) {
                    //torchArrowEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, f * 3.0F, 1.0F);
                    stack.damage(1, playerEntity, (p) -> p.sendToolBreakStatus(playerEntity.getActiveHand()));
                    float yaw = playerEntity.getYaw(), pitch = playerEntity.getPitch(), roll = 0;
                    float g = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
                    float h = -MathHelper.sin((pitch + roll) * 0.017453292F);
                    float j = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
                    float divergence = 0;

                    Vec3d vec3d = (new Vec3d(g, h, j)).normalize().add(this.random.nextTriangular(0.0, 0.0), this.random.nextTriangular(0.0, 0.0), this.random.nextTriangular(0.0, 0.0)).multiply(1.5f);
                    playerEntity.setVelocity(vec3d);

                    world.playSound(playerEntity, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isOnGround()) {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(user.getMainHandStack());
        } else {
            return TypedActionResult.fail(user.getMainHandStack());
        }
    }
}

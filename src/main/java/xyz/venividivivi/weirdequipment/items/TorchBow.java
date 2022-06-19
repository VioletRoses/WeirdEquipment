package xyz.venividivivi.weirdequipment.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import xyz.venividivivi.weirdequipment.entity.TorchArrowEntity;

public class TorchBow extends BowItem {
    public TorchBow(Settings settings) {
        super(settings);
    }

    public ItemStack torchStack = null;

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            boolean isCreative = playerEntity.getAbilities().creativeMode;
            if(torchStack == null) {
                return;
            }
            ItemStack itemStack = torchStack;
            if (!itemStack.isEmpty() || isCreative) {
                if (itemStack.isEmpty()) {
                    itemStack = new ItemStack(Items.TORCH);
                }

                int i = this.getMaxUseTime(stack) - remainingUseTicks;
                float f = getPullProgress(i);
                if (!((double) f < 0.1)) {
                    boolean isCreativeAndHasTorch = isCreative && itemStack.isOf(Items.TORCH);
                    if (!world.isClient) {
                        TorchArrowEntity torchArrowEntity = new TorchArrowEntity(world, playerEntity);
                        torchArrowEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, f * 3.0F, 1.0F);
                        stack.damage(1, playerEntity, (p) -> {
                            p.sendToolBreakStatus(playerEntity.getActiveHand());
                        });
                        world.spawnEntity(torchArrowEntity);
                        if (!isCreativeAndHasTorch && !playerEntity.getAbilities().creativeMode) {
                            itemStack.decrement(1);
                            if (itemStack.isEmpty()) {
                                playerEntity.getInventory().removeOne(itemStack);
                            }
                        }
                    }
                    world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                }
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Inventory inventory = user.getInventory();
        for(int i = 0; i < inventory.size(); ++i) {
            ItemStack itemStack = inventory.getStack(i);
            if (inventory.getStack(i).getItem().equals(Items.TORCH) || user.getAbilities().creativeMode) {
                torchStack = itemStack;
                user.setCurrentHand(hand);
                return TypedActionResult.consume(user.getStackInHand(hand));
            }
        }
        return TypedActionResult.fail(user.getMainHandStack());
    }
}

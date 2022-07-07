package xyz.venividivivi.weirdequipment.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentItems;

@Mixin(BucketItem.class)
public class BucketItemMixin {
    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/TypedActionResult;success(Ljava/lang/Object;Z)Lnet/minecraft/util/TypedActionResult;"), cancellable = true)
    private void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        ItemStack stack = user.getStackInHand(hand);
        if (stack.isOf(WeirdEquipmentItems.LARGE_LAVA_BUCKET)) {
            stack.damage(1, user, (p) -> p.setStackInHand(hand, new ItemStack(Items.BUCKET, 9)));
            cir.setReturnValue(TypedActionResult.success(user.getStackInHand(hand), world.isClient));
        }
        if (stack.isOf(WeirdEquipmentItems.BOTTOMLESS_WATER_BUCKET)) {
            cir.setReturnValue(TypedActionResult.success(stack, world.isClient));
        }
    }
}

package xyz.venividivivi.weirdequipment.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentItems;

@Mixin(BucketItem.class)
public class BucketItemMixin {
    @Inject(method = "getEmptiedStack", at = @At("HEAD"), cancellable = true)
    private static void getEmptiedStack(ItemStack stack, PlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
        if(stack.isOf(WeirdEquipmentItems.BOTTOMLESS_WATER_BUCKET)) cir.setReturnValue(stack);
    }
}

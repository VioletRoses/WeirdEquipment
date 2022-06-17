package xyz.venividivivi.weirdequipment.mixin;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.venividivivi.weirdequipment.util.ModTags;


@Mixin(SheepEntity.class)
abstract class SheepEntityMixin {
    @Redirect(method = "interactMob",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean isShears(ItemStack instance, Item item) {
        return instance.isIn(ModTags.SHEARS);
    }
}

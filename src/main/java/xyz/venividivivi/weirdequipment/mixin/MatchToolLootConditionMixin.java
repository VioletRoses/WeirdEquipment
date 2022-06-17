package xyz.venividivivi.weirdequipment.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameter;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.JsonHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(MatchToolLootCondition.class)
public class MatchToolLootConditionMixin {
    @Shadow
    ItemPredicate predicate;
    @Inject(at = @At("HEAD"), method = "test", cancellable = true)
    public void test(LootContext lootContext, CallbackInfoReturnable info) {
        ItemStack itemStack = lootContext.get(LootContextParameters.TOOL);
        JsonObject jObjectPredicate = JsonHelper.asObject(predicate.toJson(), "predicate");
        if (!itemStack.isEmpty() && itemStack.getItem() instanceof ShearsItem) {
            for (JsonElement i : JsonHelper.getArray(jObjectPredicate, "items")) {
                if (i.getAsString().equalsIgnoreCase("minecraft:shears")) {
                    info.setReturnValue(true);
                }
            }
        }
    }
}

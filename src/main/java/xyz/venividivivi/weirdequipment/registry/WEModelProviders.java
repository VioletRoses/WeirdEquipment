package xyz.venividivivi.weirdequipment.registry;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class WEModelProviders {
    public static void register() {
        ModelPredicateProviderRegistry.register(WEItems.TORCH_BOW, new Identifier("pull"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
        });

        ModelPredicateProviderRegistry.register(WEItems.TORCH_BOW, new Identifier("pulling"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

}

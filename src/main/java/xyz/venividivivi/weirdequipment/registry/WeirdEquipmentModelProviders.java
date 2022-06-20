package xyz.venividivivi.weirdequipment.registry;

import net.minecraft.util.Identifier;

import static net.minecraft.client.item.ModelPredicateProviderRegistry.*;

public class WeirdEquipmentModelProviders {
    public static void init() {
        register(WeirdEquipmentItems.TORCH_BOW, new Identifier("pull"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
        });

        register(WeirdEquipmentItems.TORCH_BOW, new Identifier("pulling"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

}

package xyz.venividivivi.weirdequipment.registry;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import xyz.venividivivi.weirdequipment.entity.TorchArrowEntityRenderer;

public class WeirdEquipmentEntityRenderers {
    public static void register() {
        EntityRendererRegistry.register(WeirdEquipmentEntityTypes.TORCH_ARROW, (context) -> new TorchArrowEntityRenderer(context));
    }
}

package xyz.venividivivi.weirdequipment.registry;

import xyz.venividivivi.weirdequipment.entity.TorchArrowEntityRenderer;

import static net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.*;

public class WeirdEquipmentEntityRenderers {
    public static void init() {
        register(WeirdEquipmentEntityTypes.TORCH_ARROW, (context) -> new TorchArrowEntityRenderer(context));
    }
}

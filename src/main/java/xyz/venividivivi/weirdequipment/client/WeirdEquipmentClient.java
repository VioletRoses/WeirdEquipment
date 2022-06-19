package xyz.venividivivi.weirdequipment.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import xyz.venividivivi.weirdequipment.entity.TorchArrowEntityRenderer;
import xyz.venividivivi.weirdequipment.registry.WEEntityTypes;

public class WeirdEquipmentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(WEEntityTypes.TORCH_ARROW, (context) -> new TorchArrowEntityRenderer(context));
    }
}

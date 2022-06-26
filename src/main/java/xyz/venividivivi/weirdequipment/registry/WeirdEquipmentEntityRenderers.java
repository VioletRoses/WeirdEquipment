package xyz.venividivivi.weirdequipment.registry;

import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import xyz.venividivivi.weirdequipment.entity.renderer.BlockCannonShotEntityRenderer;
import xyz.venividivivi.weirdequipment.entity.renderer.TorchArrowEntityRenderer;

import static net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry.*;

public class WeirdEquipmentEntityRenderers {
    public static void init() {
        register(WeirdEquipmentEntityTypes.TORCH_ARROW, TorchArrowEntityRenderer::new);
        register(WeirdEquipmentEntityTypes.ROPE_COIL, FlyingItemEntityRenderer::new);
        register(WeirdEquipmentEntityTypes.BLOCK_CANNON_SHOT, BlockCannonShotEntityRenderer::new);
    }
}

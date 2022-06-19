package xyz.venividivivi.weirdequipment.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class TorchArrowEntityRenderer extends ProjectileEntityRenderer<TorchArrowEntity> {
    public TorchArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(TorchArrowEntity entity) {
        return new Identifier("weird_equipment", "textures/entity/projectiles/torch_arrow.png");
    }
}

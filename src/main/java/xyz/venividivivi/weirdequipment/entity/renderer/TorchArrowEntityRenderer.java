package xyz.venividivivi.weirdequipment.entity.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import xyz.venividivivi.weirdequipment.entity.TorchArrowEntity;

import static xyz.venividivivi.weirdequipment.WeirdEquipment.*;

public class TorchArrowEntityRenderer extends ProjectileEntityRenderer<TorchArrowEntity> {
    public TorchArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(TorchArrowEntity entity) {
        return new Identifier(MODID, "textures/entity/projectiles/torch_arrow.png");
    }
}

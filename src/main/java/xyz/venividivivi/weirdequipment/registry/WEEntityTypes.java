package xyz.venividivivi.weirdequipment.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.venividivivi.weirdequipment.entity.TorchArrowEntity;

public class WEEntityTypes {
    public static final EntityType<TorchArrowEntity> TORCH_ARROW = FabricEntityTypeBuilder.<TorchArrowEntity>create(SpawnGroup.MISC, TorchArrowEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build();

    public static void register() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier("weird_equipment", "torch_arrow"), TORCH_ARROW);
    }
}

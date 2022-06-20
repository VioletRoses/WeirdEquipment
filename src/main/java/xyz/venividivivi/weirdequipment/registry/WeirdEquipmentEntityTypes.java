package xyz.venividivivi.weirdequipment.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import xyz.venividivivi.weirdequipment.entity.RopeCoilEntity;
import xyz.venividivivi.weirdequipment.entity.TorchArrowEntity;

import static net.minecraft.util.registry.Registry.*;
import static xyz.venividivivi.weirdequipment.WeirdEquipment.*;

public class WeirdEquipmentEntityTypes {
    public static final EntityType<TorchArrowEntity> TORCH_ARROW = FabricEntityTypeBuilder.<TorchArrowEntity>create(SpawnGroup.MISC, TorchArrowEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build();
    public static final EntityType<RopeCoilEntity> ROPE_COIL = FabricEntityTypeBuilder.<RopeCoilEntity>create(SpawnGroup.MISC, RopeCoilEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build();

    public static void init() {
        register(ENTITY_TYPE, new Identifier(MODID, "torch_arrow"), TORCH_ARROW);
        register(ENTITY_TYPE, new Identifier(MODID, "rope_coil"), ROPE_COIL);
    }
}

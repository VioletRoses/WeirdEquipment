package xyz.venividivivi.weirdequipment.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import xyz.venividivivi.weirdequipment.entity.BlockCannonShotEntity;
import xyz.venividivivi.weirdequipment.entity.RopeCoilEntity;
import xyz.venividivivi.weirdequipment.entity.TorchArrowEntity;

import static net.minecraft.util.registry.Registry.*;
import static xyz.venividivivi.weirdequipment.WeirdEquipment.*;

public class WeirdEquipmentEntityTypes {
    public static final EntityType<TorchArrowEntity> TORCH_ARROW = FabricEntityTypeBuilder.<TorchArrowEntity>create(SpawnGroup.MISC, TorchArrowEntity::new).dimensions(EntityDimensions.fixed(0.35f, 0.3f)).build();
    public static final EntityType<RopeCoilEntity> ROPE_COIL = FabricEntityTypeBuilder.<RopeCoilEntity>create(SpawnGroup.MISC, RopeCoilEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build();
    public static final EntityType<BlockCannonShotEntity> BLOCK_CANNON_SHOT = FabricEntityTypeBuilder.<BlockCannonShotEntity>create(SpawnGroup.MISC, BlockCannonShotEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build();

    public static void init() {
        register(ENTITY_TYPE, new Identifier(MODID, "torch_arrow"), TORCH_ARROW);
        register(ENTITY_TYPE, new Identifier(MODID, "rope_coil"), ROPE_COIL);
        register(ENTITY_TYPE, new Identifier(MODID, "block_cannon_shot"), BLOCK_CANNON_SHOT);
    }
}

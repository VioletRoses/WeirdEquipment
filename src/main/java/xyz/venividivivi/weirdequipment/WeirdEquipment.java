package xyz.venividivivi.weirdequipment;

import net.fabricmc.api.ModInitializer;
import xyz.venividivivi.weirdequipment.config.WeirdEquipmentConfig;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentBlocks;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentEntityTypes;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentItems;

public class WeirdEquipment implements ModInitializer {
    public static final String MODID = "weird_equipment";
    public static final String MOD_NAME = "Weird Equipment";
    @Override
    public void onInitialize() {
        WeirdEquipmentConfig.init();
        WeirdEquipmentBlocks.init();
        WeirdEquipmentItems.init();
        WeirdEquipmentEntityTypes.init();
    }
}

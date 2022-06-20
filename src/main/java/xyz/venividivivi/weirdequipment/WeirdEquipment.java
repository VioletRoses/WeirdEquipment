package xyz.venividivivi.weirdequipment;

import net.fabricmc.api.ModInitializer;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentEntityTypes;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentItems;

public class WeirdEquipment implements ModInitializer {
    public static String MODID = "weird_equipment";
    @Override
    public void onInitialize() {
        WeirdEquipmentItems.init();
        WeirdEquipmentEntityTypes.init();
    }
}

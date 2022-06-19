package xyz.venividivivi.weirdequipment;

import net.fabricmc.api.ModInitializer;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentEntityTypes;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentItems;

public class WeirdEquipment implements ModInitializer {
    @Override
    public void onInitialize() {
        WeirdEquipmentItems.register();
        WeirdEquipmentEntityTypes.register();
    }
}

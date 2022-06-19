package xyz.venividivivi.weirdequipment;

import net.fabricmc.api.ModInitializer;
import xyz.venividivivi.weirdequipment.registry.WEEntityTypes;
import xyz.venividivivi.weirdequipment.registry.WEItems;

public class WeirdEquipment implements ModInitializer {
    @Override
    public void onInitialize() {
        WEItems.register();
        WEEntityTypes.register();
    }
}

package xyz.venividivivi.weirdequipment;

import net.fabricmc.api.ModInitializer;

public class WeirdEquipment implements ModInitializer {
    @Override
    public void onInitialize() {
        WEItems.register();
    }
}

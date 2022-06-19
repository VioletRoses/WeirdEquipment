package xyz.venividivivi.weirdequipment.client;

import net.fabricmc.api.ClientModInitializer;
import xyz.venividivivi.weirdequipment.registry.WEEntityRenderers;
import xyz.venividivivi.weirdequipment.registry.WEModelProviders;

public class WeirdEquipmentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WEEntityRenderers.register();
        WEModelProviders.register();
    }
}

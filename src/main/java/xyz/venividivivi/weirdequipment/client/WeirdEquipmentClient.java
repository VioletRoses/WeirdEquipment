package xyz.venividivivi.weirdequipment.client;

import net.fabricmc.api.ClientModInitializer;
import xyz.venividivivi.weirdequipment.registry.client.WeirdEquipmentEntityRenderers;
import xyz.venividivivi.weirdequipment.registry.client.WeirdEquipmentModelProviders;

public class WeirdEquipmentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WeirdEquipmentEntityRenderers.init();
        WeirdEquipmentModelProviders.init();
    }
}

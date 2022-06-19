package xyz.venividivivi.weirdequipment.client;

import net.fabricmc.api.ClientModInitializer;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentEntityRenderers;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentModelProviders;

public class WeirdEquipmentClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        WeirdEquipmentEntityRenderers.register();
        WeirdEquipmentModelProviders.register();
    }
}

package xyz.venividivivi.weirdequipment.addon;

import dev.lambdaurora.lambdynlights.api.DynamicLightHandlers;
import dev.lambdaurora.lambdynlights.api.DynamicLightsInitializer;
import xyz.venividivivi.weirdequipment.registry.WeirdEquipmentEntityTypes;

public class DynamicLightsAddon implements DynamicLightsInitializer {
    @Override
    public void onInitializeDynamicLights() {
        DynamicLightHandlers.registerDynamicLightHandler(WeirdEquipmentEntityTypes.TORCH_ARROW, lightSource -> 12);
    }
}

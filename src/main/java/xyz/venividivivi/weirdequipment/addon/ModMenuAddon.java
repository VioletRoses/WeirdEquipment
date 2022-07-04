package xyz.venividivivi.weirdequipment.addon;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import xyz.venividivivi.weirdequipment.config.WeirdEquipmentConfigScreen;

public class ModMenuAddon implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return WeirdEquipmentConfigScreen::init;
    }

}

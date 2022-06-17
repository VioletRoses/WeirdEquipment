package xyz.venividivivi.weirdequipment;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.venividivivi.weirdequipment.items.CactusSword;
import xyz.venividivivi.weirdequipment.items.FlintAndShears;
import xyz.venividivivi.weirdequipment.materials.CactusMaterial;
import xyz.venividivivi.weirdequipment.materials.PumpkinArmorMaterial;

public class WEItems {
    public static final Item CACTUS_SWORD = new CactusSword(new CactusMaterial(), 1, -2f, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final Item JACK_O_HELMET = new ArmorItem(new PumpkinArmorMaterial(), EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final Item FLINT_AND_SHEARS = new FlintAndShears(new FabricItemSettings().group(ItemGroup.TOOLS));
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "cactus_sword"), CACTUS_SWORD);
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "jack_o_helmet"), JACK_O_HELMET);
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "flint_and_shears"), FLINT_AND_SHEARS);
    }
}

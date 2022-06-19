package xyz.venividivivi.weirdequipment.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.venividivivi.weirdequipment.items.CactusSwordItem;
import xyz.venividivivi.weirdequipment.items.FlintAndShearsItem;
import xyz.venividivivi.weirdequipment.items.NetheriteTorchPickaxeItem;
import xyz.venividivivi.weirdequipment.items.TorchBowItem;
import xyz.venividivivi.weirdequipment.materials.CactusMaterial;
import xyz.venividivivi.weirdequipment.materials.PumpkinArmorMaterial;

public class WeirdEquipmentItems {
    //Weapons
    public static final Item CACTUS_SWORD = new CactusSwordItem(new CactusMaterial(), 1, -2f, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final Item DIRT_SWORD = new SwordItem(ToolMaterials.WOOD, -3, -2.6f, new FabricItemSettings().group(ItemGroup.COMBAT));

    //Tools
    public static final Item NETHERITE_TORCH_PICKAXE = new NetheriteTorchPickaxeItem(ToolMaterials.NETHERITE, 1, -2.8f, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final Item TORCH_BOW = new TorchBowItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxDamage(384));
    public static final Item FLINT_AND_SHEARS = new FlintAndShearsItem(new FabricItemSettings().maxDamage(300).group(ItemGroup.TOOLS));

    //Armor
    public static final Item JACK_O_HELMET = new ArmorItem(new PumpkinArmorMaterial(), EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT));

    //Resources
    public static final Item TORCH_CORE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

    public static void register() {
        //Weapons
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "cactus_sword"), CACTUS_SWORD);
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "dirt_sword"), DIRT_SWORD);
        //Tools
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "netherite_torch_pickaxe"), NETHERITE_TORCH_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "torch_bow"), TORCH_BOW);
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "flint_and_shears"), FLINT_AND_SHEARS);
        //Armor
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "jack_o_helmet"), JACK_O_HELMET);
        //Resources
        Registry.register(Registry.ITEM, new Identifier("weird_equipment", "torch_core"), TORCH_CORE);
    }
}

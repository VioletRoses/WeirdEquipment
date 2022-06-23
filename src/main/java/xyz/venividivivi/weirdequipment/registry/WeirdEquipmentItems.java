package xyz.venividivivi.weirdequipment.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import xyz.venividivivi.weirdequipment.item.*;
import xyz.venividivivi.weirdequipment.material.CactusMaterial;
import xyz.venividivivi.weirdequipment.material.PumpkinArmorMaterial;

import static net.minecraft.util.registry.Registry.ITEM;
import static net.minecraft.util.registry.Registry.register;
import static xyz.venividivivi.weirdequipment.WeirdEquipment.MODID;

public class WeirdEquipmentItems {
    //Weapons
    public static final Item CACTUS_SWORD = new CactusSwordItem(new CactusMaterial(), 1, -2f, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final Item DIRT_SWORD = new SwordItem(ToolMaterials.WOOD, -3, -2.6f, new FabricItemSettings().group(ItemGroup.COMBAT));

    //Tools
    public static final Item NETHERITE_TORCH_PICKAXE = new NetheriteTorchPickaxeItem(ToolMaterials.NETHERITE, 1, -2.8f, new FabricItemSettings().group(ItemGroup.TOOLS));
    public static final Item TORCH_BOW = new TorchBowItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxDamage(384));
    public static final Item SELF_SLINGSHOT = new SelfSlingshotItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxDamage(384));
    public static final Item FLINT_AND_SHEARS = new FlintAndShearsItem(new FabricItemSettings().maxDamage(300).group(ItemGroup.TOOLS));

    //Armor
    public static final Item JACK_O_HELMET = new ArmorItem(new PumpkinArmorMaterial(), EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT));

    //Consumables
    public static final Item SMALL_ROPE_COIL = new RopeCoilItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(32), 9);
    public static final Item LARGE_ROPE_COIL = new RopeCoilItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(32), 18);
    public static final Item XL_ROPE_COIL = new RopeCoilItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(16), 36);

    //Resources
    public static final Item ROPE = new WallHangingBlockItem(WeirdEquipmentBlocks.ROPE, WeirdEquipmentBlocks.WALL_ROPE, new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item TORCH_CORE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));

    public static void init() {
        //Weapons
        register(ITEM, new Identifier(MODID, "cactus_sword"), CACTUS_SWORD);
        register(ITEM, new Identifier(MODID, "dirt_sword"), DIRT_SWORD);
        //Tools
        register(ITEM, new Identifier(MODID, "netherite_torch_pickaxe"), NETHERITE_TORCH_PICKAXE);
        register(ITEM, new Identifier(MODID, "torch_bow"), TORCH_BOW);
        register(ITEM, new Identifier(MODID, "self_slingshot"), SELF_SLINGSHOT);
        register(ITEM, new Identifier(MODID, "flint_and_shears"), FLINT_AND_SHEARS);
        //Armor
        register(ITEM, new Identifier(MODID, "jack_o_helmet"), JACK_O_HELMET);
        //Consumables
        register(ITEM, new Identifier(MODID, "small_rope_coil"), SMALL_ROPE_COIL);
        register(ITEM, new Identifier(MODID, "large_rope_coil"), LARGE_ROPE_COIL);
        register(ITEM, new Identifier(MODID, "xl_rope_coil"), XL_ROPE_COIL);
        //Resources
        register(ITEM, new Identifier(MODID, "rope"), ROPE);
        register(ITEM, new Identifier(MODID, "torch_core"), TORCH_CORE);
    }
}

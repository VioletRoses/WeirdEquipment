package xyz.venividivivi.weirdequipment.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import xyz.venividivivi.weirdequipment.block.RopeBlock;

import static net.minecraft.util.registry.Registry.*;
import static xyz.venividivivi.weirdequipment.WeirdEquipment.*;

public class WeirdEquipmentBlocks {
    public static final Block ROPE = new RopeBlock(FabricBlockSettings.of(Material.WOOL, MapColor.BROWN).strength(4.0f).dynamicBounds());

    public static void init() {
        register(BLOCK, new Identifier(MODID, "rope"), ROPE);
        register(ITEM, new Identifier(MODID, "rope"), new BlockItem(ROPE, new FabricItemSettings().group(ItemGroup.MISC)));
    }
}

package xyz.venividivivi.weirdequipment.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import xyz.venividivivi.weirdequipment.block.RopeBlock;
import xyz.venividivivi.weirdequipment.block.WallRopeBlock;

import static net.minecraft.util.registry.Registry.*;
import static xyz.venividivivi.weirdequipment.WeirdEquipment.MODID;

public class WeirdEquipmentBlocks {
    public static final Block ROPE = new RopeBlock(FabricBlockSettings.of(Material.WOOL, MapColor.BROWN).dynamicBounds().strength(0.25f).sounds(BlockSoundGroup.WOOL));
    public static final Block WALL_ROPE = new WallRopeBlock(FabricBlockSettings.of(Material.WOOL, MapColor.BROWN).dynamicBounds().strength(0.25f).sounds(BlockSoundGroup.WOOL));

    public static void init() {
        register(BLOCK, new Identifier(MODID, "rope"), ROPE);
        register(BLOCK, new Identifier(MODID, "wall_rope"), WALL_ROPE);
    }
}

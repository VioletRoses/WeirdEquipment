package xyz.venividivivi.weirdequipment.util;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {
    public static final TagKey<Item> SHEARS = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "shears"));
}

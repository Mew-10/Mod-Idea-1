package net.benjamin.ideao.util;

import net.benjamin.ideao.IdeaOMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> DOWSING_ROD_VALUABLES =
                tag("dowsing_rod_valuables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(IdeaOMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
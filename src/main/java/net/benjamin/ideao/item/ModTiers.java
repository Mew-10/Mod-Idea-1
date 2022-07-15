package net.benjamin.ideao.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier AQUAMARINE = new ForgeTier(4, 1500, 6f,
            5f, 20, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.AQUAMARINE.get()));
}

package net.benjamin.ideao.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> AQUAMARINE_ORE_PLACED = PlacementUtils.register("aquamarine_ore_placed",
            ModConfiguredFeatures.AQUAMARINE_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> PALM_TRE_PLACED =
            PlacementUtils.register("palm_tree_placed",
                    ModConfiguredFeatures.PALM_TREE, VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(1, 0.1f, 2)));
}

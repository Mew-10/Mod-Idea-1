package net.benjamin.ideao.world;

import net.benjamin.ideao.IdeaOMod;
import net.benjamin.ideao.world.gen.ModOreGeneration;
import net.benjamin.ideao.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IdeaOMod.MOD_ID)
public class ModWorldEvent {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);
    }
}

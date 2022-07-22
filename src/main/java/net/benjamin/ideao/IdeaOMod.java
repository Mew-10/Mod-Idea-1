package net.benjamin.ideao;

import com.mojang.logging.LogUtils;
import net.benjamin.ideao.block.ModBlocks;
import net.benjamin.ideao.block.entity.ModBlockEntities;
import net.benjamin.ideao.effect.ModEffects;
import net.benjamin.ideao.item.ModItems;
import net.benjamin.ideao.potion.BetterBrewingRecipe;
import net.benjamin.ideao.potion.ModPotions;
import net.benjamin.ideao.recipe.ModRecipes;
import net.benjamin.ideao.screen.ModMenuTypes;
import net.benjamin.ideao.screen.ScienceTableScreen;
import net.benjamin.ideao.screen.SeaTableScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IdeaOMod.MOD_ID)
public class IdeaOMod
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "ideao";

    public IdeaOMod()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);
        ModEffects.register(eventBus);
        ModPotions.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.SEA_TABLE_MENU.get(), SeaTableScreen::new);
        MenuScreens.register(ModMenuTypes.SCIENCE_TABLE_MENU.get(), ScienceTableScreen::new);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALM_TREE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALM_TREE_SAPLING.get(), RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                ModItems.AQUAMARINE.get(), ModPotions.FREEZE_POTION.get()));
    }
}

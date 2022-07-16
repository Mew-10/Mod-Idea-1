package net.benjamin.ideao.recipe;

import net.benjamin.ideao.IdeaOMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, IdeaOMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<SeaTableRecipe>> SEA_TABLE_SERIALIZER =
            SERIALIZERS.register("sea_crafting", () -> SeaTableRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
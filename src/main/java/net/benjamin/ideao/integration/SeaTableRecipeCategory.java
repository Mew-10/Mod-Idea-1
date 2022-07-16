package net.benjamin.ideao.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.benjamin.ideao.IdeaOMod;
import net.benjamin.ideao.block.ModBlocks;
import net.benjamin.ideao.item.ModItems;
import net.benjamin.ideao.recipe.SeaTableRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class SeaTableRecipeCategory implements IRecipeCategory<SeaTableRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(IdeaOMod.MOD_ID, "sea_crafting");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(IdeaOMod.MOD_ID, "textures/gui/sea_table_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public SeaTableRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.SEA_TABLE.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends SeaTableRecipe> getRecipeClass() {
        return SeaTableRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Sea Table");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull SeaTableRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 40).addIngredients(Ingredient.of((Items.POTION).getDefaultInstance()));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 103, 18).addIngredients(Ingredient.of(ModItems.AQUAMARINE.get()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.getResultItem());
    }
}
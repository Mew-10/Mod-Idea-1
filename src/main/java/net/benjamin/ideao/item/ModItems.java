package net.benjamin.ideao.item;

import net.benjamin.ideao.IdeaOMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IdeaOMod.MOD_ID);

    public static final RegistryObject<Item> AQUAMARINE = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));

    public static final RegistryObject<Item> AQUAMARINE_SWORD = ITEMS.register("aquamarine_sword",
            () -> new SwordItem(ModTiers.AQUAMARINE, 4, 5f,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> AQUAMARINE_PICKAXE = ITEMS.register("aquamarine_pickaxe",
            () -> new PickaxeItem(ModTiers.AQUAMARINE, 3, 4f,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> AQUAMARINE_SHOVEL = ITEMS.register("aquamarine_shovel",
            () -> new ShovelItem(ModTiers.AQUAMARINE, 3, 4f,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> AQUAMARINE_AXE = ITEMS.register("aquamarine_axe",
            () -> new AxeItem(ModTiers.AQUAMARINE, 6, 1f,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> AQUAMARINE_HOE = ITEMS.register("aquamarine_hoe",
            () -> new HoeItem(ModTiers.AQUAMARINE, 1, 1f,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));

    public static final RegistryObject<Item> AQUAMARINE_HELMET = ITEMS.register("aquamarine_helmet",
            () -> new ModArmorItemA(ModArmorMaterials.AQUAMARINE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> AQUAMARINE_CHESTPLATE = ITEMS.register("aquamarine_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AQUAMARINE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> AQUAMARINE_LEGGING = ITEMS.register("aquamarine_leggings",
            () -> new ArmorItem(ModArmorMaterials.AQUAMARINE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> AQUAMARINE_BOOTS = ITEMS.register("aquamarine_boots",
            () -> new ArmorItem(ModArmorMaterials.AQUAMARINE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));

    public static final RegistryObject<Item> DIVEING_GEAR_HELMET = ITEMS.register("diveing_gear_helmet",
            () -> new ModArmorItem(ModArmorMaterials.DIVEING_GEAR, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> DIVEING_GEAR_CHESTPLATE = ITEMS.register("diveing_gear_chestplate",
            () -> new ArmorItem(ModArmorMaterials.DIVEING_GEAR, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> DIVEING_GEAR_LEGGING = ITEMS.register("diveing_gear_leggings",
            () -> new ArmorItem(ModArmorMaterials.DIVEING_GEAR, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    public static final RegistryObject<Item> DIVEING_GEAR_BOOTS = ITEMS.register("diveing_gear_boots",
            () -> new ArmorItem(ModArmorMaterials.DIVEING_GEAR, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

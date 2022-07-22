package net.benjamin.ideao.block;

import net.benjamin.ideao.IdeaOMod;
import net.benjamin.ideao.block.custom.ModFlammableRotatedPillarBlock;
import net.benjamin.ideao.block.custom.ModSaplingBlock;
import net.benjamin.ideao.block.custom.ScienceTableBlock;
import net.benjamin.ideao.block.custom.SeaTableBlock;
import net.benjamin.ideao.item.ModCreativeModeTabs;
import net.benjamin.ideao.item.ModItems;
import net.benjamin.ideao.world.feature.tree.PalmTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, IdeaOMod.MOD_ID);

    public static final RegistryObject<Block> AQUAMARINE_BLOCK = registerBlock("aquamarine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTabs.IDEAO);

    public static final RegistryObject<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTabs.IDEAO);

    public static final RegistryObject<Block> DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTabs.IDEAO);

    public static final RegistryObject<Block> SEA_TABLE = registerBlock("sea_table",
            () -> new SeaTableBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5.5f).noOcclusion()),
            ModCreativeModeTabs.IDEAO);

    public static final RegistryObject<Block> PALM_TREE_LOG = registerBlock("palm_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTabs.IDEAO);
    public static final RegistryObject<Block> PALM_TREE_WOOD = registerBlock("palm_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTabs.IDEAO);
    public static final RegistryObject<Block> STRIPPED_PALM_TREE_LOG = registerBlock("stripped_palm_tree_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTabs.IDEAO);
    public static final RegistryObject<Block> STRIPPED_PALM_TREE_WOOD = registerBlock("stripped_palm_tree_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTabs.IDEAO);

    public static final RegistryObject<Block> PALM_TREE_PLANKS = registerBlock("palm_tree_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTabs.IDEAO);

    public static final RegistryObject<Block> PALM_TREE_LEAVES = registerBlock("palm_tree_leaves",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).noOcclusion()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTabs.IDEAO);

    public static final RegistryObject<Block> PALM_TREE_SAPLING = registerBlock("palm_tree_sapling",
            () -> new ModSaplingBlock(new PalmTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING),
                    () -> Blocks.SAND), ModCreativeModeTabs.IDEAO);

    public static final RegistryObject<Block> SCIENCE_TABLE = registerBlock("science_table",
            () -> new ScienceTableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            ModCreativeModeTabs.IDEAO);

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTabs.IDEAO)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}

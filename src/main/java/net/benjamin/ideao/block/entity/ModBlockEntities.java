package net.benjamin.ideao.block.entity;

import net.benjamin.ideao.IdeaOMod;
import net.benjamin.ideao.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, IdeaOMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SeaTableBlockEntity>> SEA_TABLE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("sea_table_block_entity", () ->
                    BlockEntityType.Builder.of(SeaTableBlockEntity::new,
                            ModBlocks.SEA_TABLE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }


}

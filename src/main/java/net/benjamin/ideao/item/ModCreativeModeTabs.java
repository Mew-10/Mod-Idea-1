package net.benjamin.ideao.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab IDEAO = new CreativeModeTab("ideao") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.AQUAMARINE.get());
        }
    }; {

    }
}

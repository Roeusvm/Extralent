package com.extralent.init;

import com.extralent.handler.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<ItemBase> ITEMS = new ArrayList<>();

    public static final ItemBase LYDRIX = new ItemBase("lydrix").setCreativeTab(CreativeTabs.MISC);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(ITEMS.toArray(new Item[0]));
    }

    public static void registerModels() {
        for (ItemBase item : ITEMS) {
            item.registerItemModel();
        }
    }
}

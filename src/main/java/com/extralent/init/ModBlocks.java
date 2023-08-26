package com.extralent.init;

import com.extralent.handler.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<BlockBase> BLOCKS = new ArrayList<>();

    public static final BlockBase LYDRIX_BLOCK = new BlockBase("lydrix_block", Material.ROCK).setCreativeTab(CreativeTabs.MISC);

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(BLOCKS.toArray(new Block[0]));
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        for (Block block : BLOCKS) {
            if (block instanceof BlockBase) {
                BlockBase blockBase = (BlockBase) block;
                registry.register(blockBase.createItemBlock());
            }
        }
    }

    public static void registerModels() {
        for (BlockBase block : BLOCKS) {
            block.registerItemModel();
        }
    }
}

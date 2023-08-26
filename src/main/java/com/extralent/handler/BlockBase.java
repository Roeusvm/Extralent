package com.extralent.handler;

import com.extralent.Extralent;
import com.extralent.info.ModInfo;
import com.extralent.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {

    protected String name;

    public BlockBase(String name, Material materialIn) {
        super(materialIn);
        this.name = name;

        this.setUnlocalizedName(ModInfo.MOD_ID + "." + name);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
    }

    public void registerItemModel() {
        Extralent.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public void setHarvestLevel(String toolClass, int level) {
        super.setHarvestLevel(toolClass, level);
    }

    @Override
    public BlockBase setHardness(float hardness) {
        super.setHardness(hardness);
        return this;
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}

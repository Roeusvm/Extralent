package com.extralent.handler;

import com.extralent.Extralent;
import com.extralent.info.ModInfo;
import com.extralent.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name) {
        this.name = name;

        this.setUnlocalizedName(ModInfo.MOD_ID + "." + name);
        this.setRegistryName(name);

        ModItems.ITEMS.add(this);
    }

    public void registerItemModel() {
        Extralent.proxy.registerItemRenderer(this, 0);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}

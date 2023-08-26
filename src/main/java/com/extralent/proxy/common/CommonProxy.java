package com.extralent.proxy.common;

import com.extralent.handler.extras.ItemFuel;
import com.extralent.info.config.Config;
import com.extralent.init.ModBlocks;
import com.extralent.init.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.Objects;

@Mod.EventBusSubscriber
public abstract class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event){
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "extralent.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(ItemFuel.instance);
    }

    public void postInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    public void registerItemRenderer(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ModBlocks.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ModItems.register(event.getRegistry());
        ModBlocks.registerItemBlocks(event.getRegistry());
    }
}

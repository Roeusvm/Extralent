package com.extralent;

import com.extralent.info.ModInfo;

import com.extralent.proxy.common.CommonProxy;
import net.minecraftforge.fml.common.SidedProxy;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.VERSION, dependencies = "required-after:forge@[14.23.5.2860,)", useMetadata = true)
public class Extralent {

    @SidedProxy(clientSide = "com.extralent.proxy.ClientProxy", serverSide = "com.extralent.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Extralent instance;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}

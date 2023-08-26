package com.extralent.proxy;

import com.extralent.init.ModBlocks;
import com.extralent.init.ModItems;
import com.extralent.proxy.common.CommonProxy;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModItems.registerModels();
        ModBlocks.registerModels();
    }
}

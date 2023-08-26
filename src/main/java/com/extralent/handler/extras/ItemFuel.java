package com.extralent.handler.extras;

import com.extralent.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemFuel {
    public static final ItemFuel instance = new ItemFuel();

    private ItemFuel() {};

    @SubscribeEvent
    public void onFurnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event)
    {
        ItemStack fuel = event.getItemStack();
        if (fuel.getItem() == ModItems.LYDRIX) {
            final int BURN_TIME_SECONDS = 100;
            event.setBurnTime(BURN_TIME_SECONDS * 20);
        }
    }
}
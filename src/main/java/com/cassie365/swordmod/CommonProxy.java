package com.cassie365.swordmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {
	
    private static final Logger LOGGER = LogManager.getLogger();
    public static GreatSword greatSword;
	
	@SubscribeEvent
	public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		LOGGER.info("Hello from Items Register!!");
		greatSword = new GreatSword();
		greatSword.setRegistryName("greatsword");
		itemRegisterEvent.getRegistry().register(greatSword);
	}

}

package com.github.cassie365.edibleweapons.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.cassie365.edibleweapons.EdibleDynamicWeapon;
import com.github.cassie365.edibleweapons.items.EdibleWeaponTiers;
import com.github.cassie365.edibleweapons.items.EdibleWeaponTypes;

import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Class which programatically generates weapons and registers them.
 * @author cassie365
 *
 */
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class EdibleWeaponsRegistrar {
	private static final Logger LOGGER = LogManager.getLogger();
	private static int[][] suitability_matrix = {
			{2,-2,0,0},
			{2,-2,0,0},
			{2,-2,0,2},
			{-2,2,-2,0},
			{-2,2,-2,0},
			{-2,2,-2,0},
			{0,0,2,0},
			{0,-2,2,0},
			{0,-2,2,0},
			{-2,0,0,2}
			
	};
	
	private static List<EdibleDynamicWeapon> weapons = new ArrayList();
	
	private static void genWeapons() {
		int wtype = 0;
		for(EdibleWeaponTypes t:EdibleWeaponTypes.values()) {
			int wtier = 0;
			for(EdibleWeaponTiers e:EdibleWeaponTiers.values()) {
				int change = suitability_matrix[wtype][wtier];
				weapons.add(new EdibleDynamicWeapon(e,3+change,(float) 2.4f+change,t));
				wtier++;
			}
			wtype++;
		}
	}
	
	@SubscribeEvent
	public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		LOGGER.info("Hello from Items Register!!");
		genWeapons();
		LOGGER.info("Generated "+weapons.size()+" weapons.");
		for(EdibleDynamicWeapon w : weapons) {
			itemRegisterEvent.getRegistry().register(w);
		}
	}

}

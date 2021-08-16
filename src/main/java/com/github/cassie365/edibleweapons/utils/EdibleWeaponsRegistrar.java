package com.github.cassie365.edibleweapons.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private static Map<String,Integer[]> suitability = new HashMap();
	
	static {
		suitability.put("Whip",new Integer[]{1,-1,0,0});
		suitability.put("Long Sword",new Integer[]{1,-1,0,0});
		suitability.put("Staff",new Integer[]{1,-1,0,1});
		suitability.put("Mace",new Integer[]{-1,1,-1,0});
		suitability.put("Hammer",new Integer[]{-1,1,-1,0});
		suitability.put("Morningstar",new Integer[]{-1,1,-1,0});
		suitability.put("Spear",new Integer[]{0,0,1,0});
		suitability.put("Rapier",new Integer[]{0,-1,1,0});
		suitability.put("Dagger",new Integer[]{0,-1,1,0});
		suitability.put("Bomb",new Integer[]{-1,0,0,1});
	}
	
	private static List<EdibleDynamicWeapon> weapons = new ArrayList();
	
	private static void genWeapons() {
		for(EdibleWeaponTypes t:EdibleWeaponTypes.values()) {
			Integer[] arr = suitability.get(t.getDesc());
			int wtier = 0;
			for(EdibleWeaponTiers e:EdibleWeaponTiers.values()) {
				int change = arr[wtier];
				int subAtt = 3+change;
				float subSpd = 2.4f+change;
				weapons.add(new EdibleDynamicWeapon(e,subAtt,subSpd,t));
				wtier++;
			}
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

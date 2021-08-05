package com.cassie365.swordmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ToolType;

public class GreatSword extends Item{
	
    private static final Logger LOGGER = LogManager.getLogger();

	public GreatSword() {
		super(new Item.Properties()
				.tab(CreativeModeTab.TAB_COMBAT)
				.durability(1561));
		LOGGER.info("New Great Sword made");
	}
	
	public String toString() {
		return "Name: "+this.getRegistryName();
	}
	
}

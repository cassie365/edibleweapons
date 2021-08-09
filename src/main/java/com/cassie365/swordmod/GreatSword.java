package com.cassie365.swordmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ToolType;

/**
 * Class representing a greatsword
 * @author cassie365
 *
 */
public class GreatSword extends SwordItem{
	
    private static final Logger LOGGER = LogManager.getLogger();

	public GreatSword() {
		LOGGER.info("New Great Sword made");
	}
	
	public String toString() {
		return "Name: "+this.getRegistryName();
	}
	
}

package com.github.cassie365.edibleweapons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.cassie365.edibleweapons.items.EdibleWeaponTiers;
import com.github.cassie365.edibleweapons.items.EdibleWeaponTypes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ToolType;

/**
 * Class representing a greatsword
 * @author cassie365
 *
 */
public class EdibleDynamicWeapon extends SwordItem{
	
    private static final Logger LOGGER = LogManager.getLogger();

	public EdibleDynamicWeapon(EdibleWeaponTiers edibleWeaponTier, int att, float speed, EdibleWeaponTypes type) {
		super(edibleWeaponTier,att+edibleWeaponTier.getQuality().getAttackBonus(),speed+edibleWeaponTier.getQuality().getSpeedBonus(),new Item.Properties().durability(edibleWeaponTier.getUses())
					.tab(CreativeModeTab.TAB_COMBAT));
		this.setRegistryName(edibleWeaponTier.getDesc()+" "+type.getDesc());
		LOGGER.info(this.getRegistryName()+" created");
	}
	
	public String toString() {
		return "Name: "+this.getRegistryName();
	}
	
}

package com.github.cassie365.edibleweapons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.cassie365.edibleweapons.items.EdibleWeaponTiers;
import com.github.cassie365.edibleweapons.items.EdibleWeaponTypes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
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
	private static final int MIN_ATT = 1;
	private static final int MAX_ATT = 4;
	private static final float MIN_SPD = 0.8f;
	private static final float MAX_SPD = 2f;
    private static final Logger LOGGER = LogManager.getLogger();

	public EdibleDynamicWeapon(EdibleWeaponTiers edibleWeaponTier, int att, float speed, EdibleWeaponTypes type) {
		super(edibleWeaponTier,calcAtt(edibleWeaponTier,att),calcSpd(edibleWeaponTier,speed),new Item.Properties().durability(edibleWeaponTier.getUses())
					.tab(CreativeModeTab.TAB_COMBAT).food(edibleWeaponTier.getFoodProps()));
		this.setRegistryName(edibleWeaponTier.getRegName()+"_"+type.getRegName());
		LOGGER.info(this.getRegistryName()+" created");
		LOGGER.info(toString());
	}
	
	private static int calcAtt(EdibleWeaponTiers edibleWeaponTier, int att) {
		int totalAtt = (int)edibleWeaponTier.getQuality().getAttackBonus()+att;
		if(totalAtt<MIN_ATT)
			return MIN_ATT;
		else if(totalAtt>MAX_ATT)
			return MAX_ATT;
		
		return totalAtt;
	}
	
	private static float calcSpd(EdibleWeaponTiers edibleWeaponTier, float spd) {
		float totalSpd = edibleWeaponTier.getQuality().getSpeedBonus()+spd;
		if(totalSpd<MIN_SPD)
			return MIN_SPD;
		else if(totalSpd>MAX_SPD)
			return MAX_SPD;
		
		return totalSpd;
	}
	
	@Override
	public String toString() {
		return "EdibleDynamicWeapon [getRegistryName()=" + getRegistryName() + "]";
	}
	
}

package com.github.cassie365.edibleweapons.items;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;

public enum EdibleWeaponQualities implements Quality {
	   HEAVY(1,-1),
	   MID(0,0),
	   LIGHT(-1,1);
	
	private final int att;
	private final int speed;
	
	private EdibleWeaponQualities(int att,int speed) {
		this.att = att;
		this.speed = speed;
	}
	
	public int getAttackBonus() {
		return this.att;
	}
	
	public int getSpeedBonus() {
		return this.speed;
	}

}

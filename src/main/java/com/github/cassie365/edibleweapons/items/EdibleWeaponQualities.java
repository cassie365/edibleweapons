package com.github.cassie365.edibleweapons.items;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;

public enum EdibleWeaponQualities implements Quality {
	   HEAVY(1,-.1f),
	   MID(0,0f),
	   LIGHT(-1,.1f);
	
	private final int att;
	private final float speed;
	
	private EdibleWeaponQualities(int att,float speed) {
		this.att = att;
		this.speed = speed;
	}
	
	public int getAttackBonus() {
		return this.att;
	}
	
	public float getSpeedBonus() {
		return this.speed;
	}

}

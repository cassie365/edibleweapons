package com.github.cassie365.edibleweapons.items;

public enum EdibleWeaponTypes {
	//WHIP("Whip"),
	LONG_SWORD("Long Sword"),
	STAFF("Staff"),
	MACE("Mace"),
	//HAMMER("Hammer"),
	MORNINGSTAR("Morningstar"),
	SPEAR("Spear"),
	RAPIER("Rapier"),
	DAGGER("Dagger"),
	//BOMB("Bomb");
	
	private String desc;
	
	private EdibleWeaponTypes(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getRegName() {
		return this.desc.toLowerCase().replace(' ', '_');
	}
}

package com.github.cassie365.edibleweapons.items;

import java.util.function.Supplier;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum EdibleWeaponTiers implements Tier{
   WHEAT("Wheat",0, 100, 5.0F, -1.0F, 5,EdibleWeaponQualities.LIGHT, () -> {
	      return Ingredient.of(ItemTags.PLANKS);
   }),
   POTATO("Potato",1, 100, 4.0F, 0.0F, 5,EdibleWeaponQualities.HEAVY,  () -> {
	      return Ingredient.of(ItemTags.PLANKS);
   }),
   CARROT("Carrot",1, 100, 4.0F, 0.0F, 5,EdibleWeaponQualities.MID, () -> {
	      return Ingredient.of(ItemTags.PLANKS);
   }),
   BEETROOT("Beetroot",2, 100, 5.0F, -1.0F, 22,EdibleWeaponQualities.MID, () -> {
	      return Ingredient.of(ItemTags.PLANKS);
   });
	
	private final String desc;
   private final int level;
   private final int uses;
   private final float speed;
   private final float damage;
   private final int enchantmentValue;
   private final Quality quality;
   private final LazyLoadedValue<Ingredient> repairIngredient;

   private EdibleWeaponTiers(String desc, int level, int uses, float speed, float damage, int enchantmentValue,Quality quality, Supplier<Ingredient> repairIngredient) {
	   this.desc = desc;
      this.level = level;
      this.uses = uses;
      this.speed = speed;
      this.damage = damage;
      this.enchantmentValue = enchantmentValue;
      this.quality = quality;
      this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
   }

   
	@Override
	public int getUses() {
		return this.uses;
	}

	@Override
	public float getSpeed() {
		return this.speed;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.damage;
	}

	@Override
	public int getLevel() {
		return this.level;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getRegName() {
		return this.desc.toLowerCase().replace(' ', '_');
	}
	
	public Quality getQuality() {
		return this.quality;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

}

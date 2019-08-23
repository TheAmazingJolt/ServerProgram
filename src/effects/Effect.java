package effects;

import java.util.ArrayList;

public class Effect {
	
	public static ArrayList<Effect> effects = new ArrayList<Effect>();
	public static Effect largeCrafting = new Effect(false, false, true, false, 2);
	public static Effect speedBoost = new Effect(false, true, false, false, 2);
	
	protected boolean healing;
	protected boolean speed;
	protected boolean inventoryExpansion;
	protected boolean damageBoost;
	
	protected float multiplier;
	
	public Effect(boolean healing, boolean speed, boolean inventoryExpansion, boolean damageBoost, float multiplier) {
		this.healing = healing;
		this.speed = speed;
		this.inventoryExpansion = inventoryExpansion;
		this.damageBoost = damageBoost;
		this.multiplier = multiplier;
	}
	
	public void tick() {
		
	}
	
	public void addEffectsToList() {
		effects.add(largeCrafting);
		effects.add(speedBoost);
	}

	public static ArrayList<Effect> getEffects() {
		return effects;
	}

	public boolean isHealing() {
		return healing;
	}

	public boolean isSpeed() {
		return speed;
	}

	public boolean isInventoryExpansion() {
		return inventoryExpansion;
	}

	public boolean isDamageBoost() {
		return damageBoost;
	}

	public float getMultiplier() {
		return multiplier;
	}
	
	
	
}

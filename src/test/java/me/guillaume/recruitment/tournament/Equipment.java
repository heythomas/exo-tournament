package me.guillaume.recruitment.tournament;

// Abstract class to create items and treat their modifier traits
public abstract class Equipment {
	protected int hp;
	protected boolean tandemItem;
	
	public abstract int hitModifier(int hitIncoming, Weapon opponentWeapon);
	public abstract int damageModifier(int initialDamage);
}

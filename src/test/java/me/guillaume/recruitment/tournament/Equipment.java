package me.guillaume.recruitment.tournament;

import java.util.function.IntPredicate;

// Abstract class to create items and treat their modifier traits
public abstract class Equipment {
	protected int hp;
	protected boolean tandemItem;
	
	public abstract int hitModifier(int hitIncoming, Weapon opponentWeapon);
	public abstract int damageModifier(int initialDamage);
	public abstract int getHp();
}

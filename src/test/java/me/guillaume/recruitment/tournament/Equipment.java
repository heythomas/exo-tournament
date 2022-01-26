package me.guillaume.recruitment.tournament;

public abstract class Equipment {
	protected int hp;
	protected boolean tandemItem;
	
	public abstract int hitModifier(int hitIncoming, Weapon opponentWeapon);
}

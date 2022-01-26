package me.guillaume.recruitment.tournament;

public class Armor extends Equipment {

	public Armor() {}

	@Override
	public int hitModifier(int hitIncoming, Weapon opponentWeapon) {
		hitIncoming -= 3;
		hitIncoming = hitIncoming <= 0 ? 0 : hitIncoming;
		return hitIncoming;
	}

	@Override
	public int damageModifier(int initialDamage) {
		initialDamage -= 1;
		initialDamage = initialDamage <= 0 ? 0 : initialDamage;
		return initialDamage;
	}
}

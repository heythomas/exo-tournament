package me.guillaume.recruitment.tournament;

public abstract class PlayerState {
	public abstract int damage_modifier(int initialDamage, Player p);
}
package me.guillaume.recruitment.tournament;

// A normal state, it changes nothing
public class Normal extends PlayerState {

	@Override
	public int damage_modifier(int initialDamage, Player p) {
		return initialDamage;
	}

}

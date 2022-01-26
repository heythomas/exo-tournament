package me.guillaume.recruitment.tournament;

// Specific state vicious
public class Vicious extends PlayerState {
	int counter = 2;
	
	@Override
	public int damage_modifier(int initialDamage, Player p) {
		if(counter > 0) {
			this.counter -= 1;
			return initialDamage+20;
		}
		return initialDamage;
	}

}

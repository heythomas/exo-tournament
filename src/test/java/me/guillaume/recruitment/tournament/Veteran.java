package me.guillaume.recruitment.tournament;

// Specific state 
public class Veteran extends PlayerState {

	@Override
	public int damage_modifier(int initialDamage, Player p) {
		if(p.isBelow30p()) {
			return 2*initialDamage;
		}
		return initialDamage;
	}

}

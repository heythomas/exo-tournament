package me.guillaume.recruitment.tournament;

public class GreatSword extends Weapon {
	
	// Specific parameters used only by the GS are created here
	private int accuracy = 2;
	private int accuracyOver = 3;
	private int currentHitCounter = 0;
	
	public GreatSword() {
		this.damage = 12;
	}
	
	// Because GreatSword is an exception we chose to declare a new getDamage for it
	public int getDamage() {
		int damageGiven;
		if(this.currentHitCounter <= this.accuracy) {
			damageGiven = this.damage;
		}
		else {
			damageGiven = 0;
		}
		this.currentHitCounter = (this.currentHitCounter + 1) % this.accuracyOver+1;
		
		return damageGiven;
	}
}

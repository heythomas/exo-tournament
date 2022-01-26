package me.guillaume.recruitment.tournament;

public class Highlander extends Player {
	
	// Basic constructor
	public Highlander() {
		this.hp = 150;
		this.weapon = new GreatSword();
	}
	
	// Second constructor to give a state of the player (Berserk/Vicious)
	public Highlander(String state) {
		this.hp = 150;
		this.initialHp = this.hp;
		this.weapon = new GreatSword();
		this.stateOfPlayer = stateFinder(state);
	}
	
	// Equipment method described here to return the desired type of Object in the end, not a "Player" one
	public Highlander equip(String equipmentName) {
		Equipment equipmentFound = super.equipmentFinder(equipmentName);
		if(equipmentFound != null) {
			this.equipment.add(equipmentFound);
		}
		else {
			Weapon weaponFound = super.weaponFinder(equipmentName);
			if(weaponFound != null) {
				this.weapon = super.weaponFinder(equipmentName);
			}
		}
		return this;
	}
}

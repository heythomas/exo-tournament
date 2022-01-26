package me.guillaume.recruitment.tournament;

public class Swordsman extends Player {
	
	// Basic constructor
	public Swordsman() {
		this.hp = 100;
		this.weapon = new HandSword();
		this.initialHp = this.hp;
	}
	
	// Second constructor to give a state of the player (Berserk/Vicious)
	public Swordsman(String state) {
		this.hp = 100;
		this.weapon = new HandSword();
		this.stateOfPlayer = stateFinder(state);
	}
	
	// Equipment method described here to return the desired type of Object in the end, not a "Player" one
	public Swordsman equip(String equipmentName) {
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

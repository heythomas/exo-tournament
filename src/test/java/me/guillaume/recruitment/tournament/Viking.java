package me.guillaume.recruitment.tournament;

public class Viking extends Player {
	
	// Basic constructor
	public Viking() {
		this.hp = 120;
		this.initialHp = this.hp;
		this.weapon = new HandAxe();
	}
	
	// Second constructor to give a state of the player (Berserk/Vicious)
	public Viking(String state) {
		this.hp = 120;
		this.weapon = new HandAxe();
		this.stateOfPlayer = stateFinder(state);
	}
	
	// Equipment method described here to return the desired type of Object in the end, not a "Player" one
	public Viking equip(String equipmentName) {
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

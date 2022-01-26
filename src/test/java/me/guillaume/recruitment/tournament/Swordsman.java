package me.guillaume.recruitment.tournament;

public class Swordsman extends Player {
	
	public Swordsman() {
		this.hp = 100;
		this.weapon = new HandSword();
	}
	
	public Swordsman equip(String equipmentName) {
		this.equipment = super.equipmentFinder(equipmentName);
		return this;
	}
}

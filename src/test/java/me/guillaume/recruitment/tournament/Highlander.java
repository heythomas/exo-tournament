package me.guillaume.recruitment.tournament;

public class Highlander extends Player {
	public Highlander() {
		this.hp = 150;
		this.weapon = new GreatSword();
	}
	
	public Highlander equip(String equipmentName) {
		this.equipment.add(super.equipmentFinder(equipmentName));
		return this;
	}
}

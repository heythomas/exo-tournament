package me.guillaume.recruitment.tournament;

public class Viking extends Player {
	
	public Viking() {
		this.hp = 120;
		this.weapon = new HandAxe();
	}
	
	public Viking equip(String equipmentName) {
		this.equipment.add(super.equipmentFinder(equipmentName));
		return this;
	}
}

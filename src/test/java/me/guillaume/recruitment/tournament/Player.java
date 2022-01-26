package me.guillaume.recruitment.tournament;

import java.util.ArrayList;

public class Player {
	protected int hp;
	protected Weapon weapon;
	protected ArrayList<Equipment> equipment = new ArrayList<Equipment>();
	
	// Called to engage a death match againt the opponent
	public void engage(Player p) {
		boolean fightIsOver = false;
		while(!fightIsOver) {
			if(this.attack(p)) {
				if(!p.attack(this)) {
					fightIsOver = true;
				}
			}
			else {
				fightIsOver = true;
			}
		}
	}
	
	// Called to attack once the opponent
	public boolean attack(Player p) {
		int damageDone = this.weapon.getDamage();
		
		if(!this.equipment.isEmpty()) {
			for(Equipment el : this.equipment) {
				damageDone = el.damageModifier(damageDone);
			}
		}
		
		// If it appears that the player is not attacking we do not invoke the attack
		if(damageDone == 0) {
			return true;
		}
		
		return p.receive_attack(damageDone, this.weapon);
	}
	
	// Used to receive damage and treat damage modifier equipments
	public boolean receive_attack(int damage, Weapon opponentWeapon) {
		
		if(!this.equipment.isEmpty()) {
			for(Equipment el : this.equipment) {
				damage = el.hitModifier(damage, opponentWeapon);
			}
		}
		
		this.hp -= damage;
		
		if(this.hp <= 0) {
			this.hp = 0;
			return false;
		}
		else {
			return true;
		}
	}
	
	// Used only for unitary tests
	public int hitPoints() {
		return this.hp;
	}
	
	// Find equipment from a String given by the user (called by child class)
	public Equipment equipmentFinder(String equipmentName) {
		Equipment equipmentFound;
		switch(equipmentName) {
			case "buckler":
				equipmentFound = new Buckler();
				break;
			case "armor":
				equipmentFound = new Armor();
				break;
			default:
				equipmentFound = null;
				System.out.println("ERROR, item not found...");
		}
		return equipmentFound;
	}
}

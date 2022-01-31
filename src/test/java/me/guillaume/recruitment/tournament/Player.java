package me.guillaume.recruitment.tournament;

import java.util.ArrayList;

public class Player {
	protected int initialHp;
	protected int hp;
	protected Weapon weapon;
	protected ArrayList<Equipment> equipment = new ArrayList<Equipment>();
	
	// State of the player
	protected PlayerState stateOfPlayer = new Normal();
	
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
		// In the opposite, if the player is attacking, we use the state to change (or not) his damages
		else {
			damageDone = this.stateOfPlayer.damage_modifier(damageDone, this);
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
	
	// Used only for unitary tests to get the hp
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
	
	// Find equipment from a String given by the user (called by child class)
	public Weapon weaponFinder(String weaponName) {
		Weapon equipmentFound;
		switch(weaponName) {
			case "axe":
				equipmentFound = new HandAxe();
				break;
			case "sword":
				equipmentFound = new HandSword();
				break;
			case "gs":
				equipmentFound = new GreatSword();
				break;
			default:
				equipmentFound = null;
				System.out.println("ERROR, item not found...");
		}
		return equipmentFound;
	}
	
	// Find a state from string
	public PlayerState stateFinder(String stateName) {
		PlayerState stateFound;
		
		switch(stateName) {
			case "Vicious":
				stateFound = new Vicious();
				break;
			case "Veteran":
				stateFound = new Veteran();
				break;
			default:
				stateFound = new Normal();
		}
		
		return stateFound;
	}
	
	// Used by berserk to know if the player is below 30% of his initial hp
	public boolean isBelow30p() {
		if(initialHp*0.3 >= this.hp) {
			return true;
		}
		return false;
	}
	
	// Get initial Hp for tests
	public int getInitialHp() {
		return this.initialHp;
	}
}

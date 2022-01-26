package me.guillaume.recruitment.tournament;

public class Player {
	protected int hp;
	protected Weapon weapon;
	protected Equipment equipment = null;
	
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
	
	public boolean attack(Player p) {
		return p.receive_attack(this.weapon.getDamage(), this.weapon);
	}
	
	public boolean receive_attack(int damage, Weapon opponentWeapon) {
		
		if(equipment != null) {
			damage = this.equipment.hitModifier(damage, opponentWeapon);
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
	
	public int hitPoints() {
		return this.hp;
	}
	
	public Equipment equipmentFinder(String equipmentName) {
		Equipment equipmentFound;
		switch(equipmentName) {
			case "buckler":
				equipmentFound = new Buckler();
				break;
			default:
				equipmentFound = null;
				System.out.println("ERROR, item not found...");
		}
		return equipmentFound;
	}
}

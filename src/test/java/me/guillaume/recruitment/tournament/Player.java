package me.guillaume.recruitment.tournament;

public class Player {
	protected int hp;
	protected Weapon weapon;
	
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
		return p.receive_attack(this.weapon.getDamage());
	}
	
	public boolean receive_attack(int damage) {
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
}

package me.guillaume.recruitment.tournament;

public class Buckler extends Equipment {
	
	public Buckler() {
		this.hp = 3;
		this.tandemItem = true;
	}
	
	@Override
	public int hitModifier(int hitIncoming, Weapon opponentWeapon) {
		if(this.tandemItem && this.hp != 0) {
				hitIncoming = 0;
				
			// Check if the hit is from an axe
			if(opponentWeapon.getClass() == HandAxe.class) {
				this.hp--;
			}
			tandemItem = false;
		}
		else {
			tandemItem = true;
		}
		
		return hitIncoming;
	}

}

package me.guillaume.recruitment.tournament;

public class Buckler extends Equipment {
	
	// Specific parameters used only by buckler are created here
	private int hp = 3;
	private boolean tandemItem = true;
	
	public Buckler() {}
	
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

	@Override
	public int damageModifier(int initialDamage) {
		return initialDamage;
	}

}

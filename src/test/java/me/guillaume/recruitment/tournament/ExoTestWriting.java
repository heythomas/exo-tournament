package me.guillaume.recruitment.tournament;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 * This is a duel simulation
 *
 * Blow exchange are sequential, A engage B means that A will give the first blow, then B will respond
 *
 */
public class ExoTestWriting {

    /**
     * A lot of hit with a sword on a buckler, the damage are blocked but the buckler isn't damaged
     */
    @Test
    public void BucklerVsSword() {

        Swordsman swordsman = new Swordsman();

        Viking viking = new Viking()
                .equip("buckler");

        swordsman.engage(viking);

        assertThat(viking.equipment.get(0).getClass()).isEqualTo(Buckler.class);
        assertThat(viking.equipment.get(0).getHp()).isEqualTo(3);

    }
    
    /**
     * 2 hits with an axe on a buckler, the damage are blocked once but the buckler is damaged once to
     */
    
    @Test
    public void BucklerVsTwoAxeHit() {

        Swordsman swordsman = new Swordsman()
        		.equip("buckler");

        Viking viking = new Viking();
                

        viking.attack(swordsman);
        viking.attack(swordsman);

        assertThat(swordsman.equipment.get(0).getClass()).isEqualTo(Buckler.class);
        assertThat(swordsman.equipment.get(0).getHp()).isEqualTo(2);
        assertThat(swordsman.getHp()).isEqualTo(swordsman.getInitialHp() - 6);

    }
    
    /**
     * 5 hits with an axe on a buckler, the damage are blocked 3 times but the buckler is destroyed
     */
    
    @Test
    public void BucklerVsFiveAxeHit() {

        Swordsman swordsman = new Swordsman()
        		.equip("buckler");

        Viking viking = new Viking();
                

        viking.attack(swordsman);
        viking.attack(swordsman);
        viking.attack(swordsman);
        viking.attack(swordsman);
        viking.attack(swordsman);

        assertThat(swordsman.equipment.get(0).getClass()).isEqualTo(Buckler.class);
        assertThat(swordsman.equipment.get(0).getHp()).isEqualTo(0);
        assertThat(swordsman.getHp()).isEqualTo(swordsman.getInitialHp() - 12);

    }
    
}

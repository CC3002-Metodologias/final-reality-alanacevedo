package com.github.alanacevedo.finalreality.model.weapon;

import com.github.alanacevedo.finalreality.model.character.player.charClasses.Knight;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.Thief;

public class Sword extends AbstractWeapon{
    /**
     * Creates a sword weapon
     * @param name   name of the weapon
     * @param damage damage this weapon deals
     * @param weight weight of the weapon
     */
    public Sword(String name, int damage, int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToKnight(Knight knight) {
        knight.setEquippedWeapon(this);
    }

    @Override
    public void equipToThief(Thief thief) {
        thief.setEquippedWeapon(this);
    }
}

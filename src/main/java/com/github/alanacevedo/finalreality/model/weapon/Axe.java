package com.github.alanacevedo.finalreality.model.weapon;

import com.github.alanacevedo.finalreality.model.character.player.charClasses.Engineer;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.Knight;

public class Axe extends AbstractWeapon {
    /**
     * Creates a weapon with a name, a base damage, speed and it's type.
     * @param name   name of the weapon
     * @param damage damage this weapon deals
     * @param weight weight of the weapon
     */
    public Axe(String name, int damage, int weight) {
        super(name, damage, weight);
    }


    @Override
    public void equipToKnight(Knight knight) {
        knight.setEquippedWeapon(this);
    }

    @Override
    public void equipToEngineer(Engineer engineer) {
        engineer.setEquippedWeapon(this);
    }
}
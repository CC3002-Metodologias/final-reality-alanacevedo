package com.github.alanacevedo.finalreality.model.weapon;

import com.github.alanacevedo.finalreality.model.character.player.charClasses.Engineer;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.Thief;

public class Bow extends AbstractWeapon{
    /**
     * Creates a weapon with a name, a base damage, speed and it's type.
     *
     * @param name   name of the weapon
     * @param damage damage this weapon deals
     * @param weight weight of the weapon
     */
    public Bow(String name, int damage, int weight) {
        super(name, damage, weight);
    }

    @Override
    public int equipToEngineer(Engineer engineer) {
        engineer.setEquippedWeapon(this);
        return 1;
    }

    @Override
    public int equipToThief(Thief thief) {
        thief.setEquippedWeapon(this);
        return 1;
    }
}

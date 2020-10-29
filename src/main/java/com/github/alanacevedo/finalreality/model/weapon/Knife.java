package com.github.alanacevedo.finalreality.model.weapon;

import com.github.alanacevedo.finalreality.model.character.player.charClasses.BlackMage;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.Knight;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.Thief;

public class Knife extends AbstractWeapon {
    /**
     * Creates a weapon with a name, a base damage, speed and it's type.
     *
     * @param name   name of the weapon
     * @param damage damage this weapon deals
     * @param weight weight of the weapon
     */
    public Knife(String name, int damage, int weight) {
        super(name, damage, weight);
    }

    @Override
    public void equipToThief(Thief thief) {
        thief.setEquippedWeapon(this);
    }

    @Override
    public void equipToKnight(Knight knight) {
        knight.setEquippedWeapon(this);
    }

    @Override
    public void equipToBlackMage(BlackMage blackMage) {
        blackMage.setEquippedWeapon(this);
    }
}

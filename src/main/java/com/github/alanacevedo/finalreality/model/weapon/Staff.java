package com.github.alanacevedo.finalreality.model.weapon;

import com.github.alanacevedo.finalreality.model.character.player.charClasses.BlackMage;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.WhiteMage;

import java.util.Objects;

public class Staff extends AbstractWeapon {
    int magicDamage;

    /**
     * Creates a weapon with a name, a base damage, speed and it's type.
     *
     * @param name   name of the weapon
     * @param damage damage this weapon deals
     * @param weight weight of the weapon
     **/

    public Staff(String name, int damage, int weight, int magicDamage) {
        super(name, damage, weight);
        this.magicDamage = magicDamage;
    }
    @Override
    public int getMagicDamage() {
        return this.magicDamage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Staff)) {
            return false;
        }
        final Staff weapon = (Staff) o;
        return getDamage() == weapon.getDamage() &&
                getWeight() == weapon.getWeight() &&
                getName().equals(weapon.getName()) &&
                getMagicDamage() == weapon.getMagicDamage();
    }

    /**
     * Función utilizada junto a equals.
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDamage(), getWeight());
    }

    @Override
    public void equipToBlackMage(BlackMage blackMage) {
        blackMage.setEquippedWeapon(this);
    }

    @Override
    public void equipToWhiteMage(WhiteMage whiteMage) {
        whiteMage.setEquippedWeapon(this);
    }
}

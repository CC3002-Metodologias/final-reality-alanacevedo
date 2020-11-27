package com.github.alanacevedo.finalreality.model.character.player.charClasses;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.AbsPlayerCharacter;
import com.github.alanacevedo.finalreality.model.weapon.AbstractWeapon;
import com.github.alanacevedo.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * a class that represents a Thief character
 */

public class Thief extends AbsPlayerCharacter {

    /**
     * Initializes an Thief character
     * @param name
     *      name of the character
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param HP default: 100
     *     this character's hit points (health points)
     * @param DEF default: 15
     *     this character's defense points
     */

    public Thief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                  int HP, int DEF) {
        super(name, turnsQueue, HP, DEF);

    }

    public Thief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        this(name, turnsQueue, 100, 15);
    }


    @Override
    public int hashCode() {
        return Objects.hash(getHP(), getDEF(), getName());
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Thief)) {
            return false;
        }
        final AbsPlayerCharacter that = (AbsPlayerCharacter) o;
        return getName().equals(that.getName())
                && getHP() == that.getHP()
                && getDEF() == that.getDEF();
    }

    // Equipamiento de armas

    @Override
    public void equip(IWeapon weapon) {
        weapon.equipToThief(this);
    }
}

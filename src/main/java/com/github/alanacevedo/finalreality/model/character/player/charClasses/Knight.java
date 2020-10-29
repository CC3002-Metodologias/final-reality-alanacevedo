package com.github.alanacevedo.finalreality.model.character.player.charClasses;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.character.player.AbsPlayerCharacter;
import com.github.alanacevedo.finalreality.model.weapon.AbstractWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * a class that represents a Knight character
 */
public class Knight extends AbsPlayerCharacter {
    /**
     * Initializes a Knight character
     *
     * @param name       name of the character
     * @param turnsQueue the queue with the characters waiting for their turn
     * @param HP         default: 200
     *                   this character's hit points (health points)
     * @param DEF        default: 20
     *                   this character's defense points
     */

    public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                  int HP, int DEF) {
        super(name, turnsQueue, CharacterClass.KNIGHT, HP, DEF);

    }

    public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        this(name, turnsQueue, 200, 20);
    }


    /**
     * Función utilizada junto a equals.
     *
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(), getHP(), getDEF(), getName());
    }

    /**
     * @param o Other Object (Character ideally)
     * @return true if 'o' has the same characteristics as this character.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbsPlayerCharacter)) {
            return false;
        }
        final AbsPlayerCharacter that = (AbsPlayerCharacter) o;
        return getCharacterClass() == that.getCharacterClass()
                && getName().equals(that.getName())
                && getHP() == that.getHP()
                && getDEF() == that.getDEF();
    }

    @Override
    public void equip(AbstractWeapon weapon) {
        weapon.equipToKnight(this);
    }
}
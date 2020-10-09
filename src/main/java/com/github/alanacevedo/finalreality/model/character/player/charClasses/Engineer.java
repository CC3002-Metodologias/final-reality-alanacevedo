package com.github.alanacevedo.finalreality.model.character.player.charClasses;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.AbsMageCharacter;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.character.player.AbsPlayerCharacter;
import com.github.alanacevedo.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * a class that represents an Engineer character.
 */

public class Engineer extends AbsPlayerCharacter {

    /**
     * Initializes an Engineer character
     * @param name
     *      name of the character
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param HP default: 100
     *     this character's hit points (health points)
     * @param DEF default: 10
     *     this character's defense points
     */
    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                  int HP, int DEF) {
        super(name, turnsQueue,CharacterClass.ENGINEER, HP, DEF);
        allowedWeapons = new WeaponType[]{WeaponType.BOW, WeaponType.AXE};
    }

    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        this(name, turnsQueue, 100, 10);
    }


    /**
     * Función utilizada junto a equals.
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(), getCharacterHP(), getCharacterDEF(), getName());
    }

    /**
     *
     * @param o Other Object (Character ideally)
     *  @return
     *     true if 'o' has the same characteristics as this character.
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
                && getCharacterHP() == that.getCharacterHP()
                && getCharacterDEF() == that.getCharacterDEF();
    }
}

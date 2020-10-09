package com.github.alanacevedo.finalreality.model.character.player.charClasses;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.character.player.AbsMageCharacter;
import com.github.alanacevedo.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * a class that represents a White Mage character
 */

public class BlackMage extends AbsMageCharacter {

    /**
     * Initializes a Black Mage character
     * @param name
     *      name of the character
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param HP default: 80
     *     this character's hit points (health points)
     * @param DEF default: 10
     *     this character's defense points
     * @param MP default: 100
     *      this characters' magic points (mana points)
     */

    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                     int HP, int DEF, int MP){
        super(name, turnsQueue, CharacterClass.BLACK_MAGE, HP, DEF, MP);
        allowedWeapons = new WeaponType[] {WeaponType.STAFF, WeaponType.KNIFE};
    }

    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        this(name, turnsQueue, 80, 10, 100);
    }

    /**
     * Función utilizada junto a equals.
     * @return
     *      Hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCharacterClass(), getCharacterHP(), getCharacterDEF(),
                getCharacterMP(), getName());
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
        if (!(o instanceof AbsMageCharacter)) {
            return false;
        }
        final AbsMageCharacter that = (AbsMageCharacter) o;
        return getCharacterClass() == that.getCharacterClass()
                && getName().equals(that.getName())
                && getCharacterHP() == that.getCharacterHP()
                && getCharacterDEF() == that.getCharacterDEF()
                && getCharacterMP() == that.getCharacterMP();
    }
}

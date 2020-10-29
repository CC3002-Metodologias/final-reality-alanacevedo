package com.github.alanacevedo.finalreality.model.character.player.charClasses;

import com.github.alanacevedo.finalreality.model.character.AbstractCharacter;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.character.player.AbsMageCharacter;
import com.github.alanacevedo.finalreality.model.weapon.AbstractWeapon;
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
        return Objects.hash(getCharacterClass(), getHP(), getDEF(),
                getMP(), getName());
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
                && getHP() == that.getHP()
                && getDEF() == that.getDEF()
                && getMP() == that.getMP();
    }

    // Equipamiento de armas

    @Override
    public void equip(AbstractWeapon weapon) {
        weapon.equipToBlackMage(this);
    }

    /**
     * Casts Thunder into a character
     * @param character character affected by the spell
     */
    public void castThunder(AbstractCharacter character) {
        int mpCost = 15;
        if (aliveStatus && character.isAlive() && this.equippedWeapon != null && this.getMP() >= mpCost){
            int magicDamage = this.equippedWeapon.getMagicDamage();
            character.receiveDamage(magicDamage);
            this.spendMP(mpCost);
            //30% chance thunder
        }
    }

    /**
     * Casts Fire into a character
     * @param character character affected by the spell
     */
    public void castFire(AbstractCharacter character) {
        int mpCost = 15;
        if (aliveStatus && character.isAlive() && this.equippedWeapon != null && this.getMP() >= mpCost){
            int magicDamage = this.equippedWeapon.getMagicDamage();
            character.receiveDamage(magicDamage);
            this.spendMP(mpCost);
            //20% chance burn
        }
    }
}

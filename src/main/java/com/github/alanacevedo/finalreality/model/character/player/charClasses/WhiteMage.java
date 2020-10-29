package com.github.alanacevedo.finalreality.model.character.player.charClasses;

import com.github.alanacevedo.finalreality.model.character.AbstractCharacter;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.AbsMageCharacter;
import com.github.alanacevedo.finalreality.model.weapon.AbstractWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * a class that represents a White Mage character
 */
public class WhiteMage extends AbsMageCharacter {

    /**
     * Initializes a White Mage character
     *
     * @param name
     *      name of the character
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param HP  default: 80
     *     this character's hit points (health points)
     * @param DEF default:10
     *     this character's defense points
     * @param MP  default: 100
     *       this characters' magic points (mana points)
     */

    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                     int HP, int DEF, int MP) {
        super(name, turnsQueue, HP, DEF, MP);
    }

    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        this(name, turnsQueue, 80, 10, 100);
    }


    @Override
    public int hashCode() {
        return Objects.hash(getHP(), getDEF(),
                getMP(), getName());
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WhiteMage)) {
            return false;
        }
        final AbsMageCharacter that = (AbsMageCharacter) o;
        return  getName().equals(that.getName())
                && getHP() == that.getHP()
                && getDEF() == that.getDEF()
                && getMP() == that.getMP();
    }

    // Equipamiento de armas


    @Override
    public void equip(AbstractWeapon weapon) {
        weapon.equipToWhiteMage(this);
    }

    public void castCure(AbstractCharacter character) {
        int mpCost = 15;

        if (character.isAlive() && this.isAlive() && this.getMP() >= mpCost) {
            int healAmmount = (int) (character.getMaxHP() * 0.3);
            character.heal(healAmmount);
            this.spendMP(mpCost);
        }
    }

    // public void castPoison(AbstractCharacter character) { }

    // public void castParalisis(AbstractCharacter character= { }
}

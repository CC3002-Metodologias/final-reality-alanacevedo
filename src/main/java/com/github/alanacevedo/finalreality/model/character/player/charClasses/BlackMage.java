package com.github.alanacevedo.finalreality.model.character.player.charClasses;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.AbsMageCharacter;
import com.github.alanacevedo.finalreality.model.magic.BlackMagic.*;
import com.github.alanacevedo.finalreality.model.weapon.IWeapon;
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

    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int HP, int DEF, int MP){
        super(name, turnsQueue, HP, DEF, MP);
        spellBook.addSpell(new Fire(this));
        spellBook.addSpell(new Thunder(this));
    }

    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
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
        if (!(o instanceof BlackMage)) {
            return false;
        }
        final AbsMageCharacter that = (AbsMageCharacter) o;
        return getName().equals(that.getName())
                && getHP() == that.getHP()
                && getDEF() == that.getDEF()
                && getMP() == that.getMP();
    }

    @Override
    public int equip(IWeapon weapon) {
        return weapon.equipToBlackMage(this);
    }

}

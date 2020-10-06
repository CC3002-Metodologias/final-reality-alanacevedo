package com.github.alanacevedo.finalreality.model.character.player.charClasses;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.character.player.AbsMageCharacter;
import com.github.alanacevedo.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * a class that represents a White Mage character
 */
public class White_Mage extends AbsMageCharacter {

    /**
     * Initializes a White Mage character
     * @param name
     *      name of the character
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param HP
     *     this character's hit points (health points)
     * @param DEF
     *     this character's defense points
     * @param MP
     *      this characters' magic points (mana points)
     */

    White_Mage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
               int HP, int DEF, int MP){
        super(name, turnsQueue, CharacterClass.WHITE_MAGE, HP, DEF, MP);
        allowedWeapons = new WeaponType[]{WeaponType.STAFF};
    }

    White_Mage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue){
        this(name, turnsQueue, 80, 10, 100);
    }

}

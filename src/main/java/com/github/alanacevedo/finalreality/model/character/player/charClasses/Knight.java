package com.github.alanacevedo.finalreality.model.character.player.charClasses;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.character.player.AbsPlayerCharacter;
import com.github.alanacevedo.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * a class that represents a Knight character
 */
public class Knight extends AbsPlayerCharacter {
    /**
     * Initializes a Knight character
     * @param name
     *      name of the character
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param HP
     *     this character's hit points (health points)
     * @param DEF
     *     this character's defense points
     */

    public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                  int HP, int DEF) {
        super(name, turnsQueue,CharacterClass.KNIGHT, HP, DEF);
        allowedWeapons = new WeaponType[]{WeaponType.SWORD, WeaponType.AXE, WeaponType.KNIFE};

    }

    public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue) {
        this(name, turnsQueue, 200, 20);
    }
}

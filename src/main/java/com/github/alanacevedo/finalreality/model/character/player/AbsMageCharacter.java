package com.github.alanacevedo.finalreality.model.character.player;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that represents a mage character.
 */
public abstract class AbsMageCharacter extends AbsPlayerCharacter {

    protected int MP;

    /**
     * Initializes a mage character
     * @param name
     *      name of the character
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param characterClass
     *      class of this character
     * @param HP
     *     this character's hit points (health points)
     * @param DEF
     *     this character's defense points
     * @param MP
     *     this characters' magic points (mana points)
     */
    public AbsMageCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                            final CharacterClass characterClass, int HP, int DEF, int MP) {
        super(name, turnsQueue, characterClass, HP, DEF);
        this.MP = MP;
    }


    /**
     * @return
     *     this characters Mana Points (Magic points)
     */
    public int getMP(){
        return this.MP;
    }

    public void spendMP(int ammount) {
        this.MP -= ammount;
    }
}

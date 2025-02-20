package com.github.alanacevedo.finalreality.model.character.player;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.magic.SpellBook;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that represents a mage character.
 */
public abstract class AbsMageCharacter extends AbsPlayerCharacter implements IMageCharacter {

    protected int MP;
    protected SpellBook spellBook;

    /**
     * Initializes a mage character
     * @param name
     *      name of the character
     * @param turnsQueue
     *      the queue with the characters waiting for their turn
     * @param HP
     *     this character's hit points (health points)
     * @param DEF
     *     this character's defense points
     * @param MP
     *     this characters' magic points (mana points)
     */
    public AbsMageCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                             int HP, int DEF, int MP) {
        super(name, turnsQueue, HP, DEF);
        this.MP = MP;
        spellBook = new SpellBook();
    }


    @Override
    public int getMP(){
        return this.MP;
    }

    @Override
    public void spendMP(int ammount) {
        this.MP -= ammount;
    }

    @Override
    public boolean isMage() {
        return true;
    }

    @Override
    public SpellBook getSpellBook() {
        return spellBook;
    }
}

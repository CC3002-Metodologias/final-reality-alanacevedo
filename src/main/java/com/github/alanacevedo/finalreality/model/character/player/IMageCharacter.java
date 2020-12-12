package com.github.alanacevedo.finalreality.model.character.player;

import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.magic.SpellBook;

public interface IMageCharacter extends IPlayableCharacter {

    /**
     * @return
     *     this characters current Mana Points (Magic points)
     */
    int getMP();

    /**
     * Spends this character's MP.
     */
    void spendMP(int ammount);

    SpellBook getSpellBook();

}

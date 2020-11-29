package com.github.alanacevedo.finalreality.model.character.player;

import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;

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
}

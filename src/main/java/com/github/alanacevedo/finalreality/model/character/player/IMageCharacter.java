package com.github.alanacevedo.finalreality.model.character.player;

public interface IMageCharacter {

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

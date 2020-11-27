package com.github.alanacevedo.finalreality.model.player;

import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;

public interface IParty {

    /**
     * Adds a character to the player's party.
     * @param character character to be added
     */
    void addCharacter(IPlayableCharacter character);

    /**
     * Returns the character located in the given slot.
     * @param slot party slot to be searched
     * @return the character located in that slot
     */
    IPlayableCharacter getCharacter(int slot);

    /**
     * Returns the current ammount of characters in the party.
     * Useful when adding characters to the party.
     */
    int getCurrentSize();
}

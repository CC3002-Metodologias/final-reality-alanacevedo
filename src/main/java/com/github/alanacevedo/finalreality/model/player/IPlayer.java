package com.github.alanacevedo.finalreality.model.player;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.weapon.IWeapon;

public interface IPlayer {

    /**
     * Adds a character to this player's party
     * @param character character to be added
     */
    void addCharacterToParty(IPlayableCharacter character);

    /**
     * Adds a weapon to this player's inventory
     * @param weapon weapon to be added
     */
    void addWeaponToInventory(IWeapon weapon);

    /**
     * Swaps weapons from 2 slots. Can be used to move a weapon from a slot to
     * an empty one.
     * @param slot1 first inventory slot
     * @param slot2 second inventory slot
     */
    void swapInventorySlots(int slot1, int slot2);

    /**
     * Returns the character located in the player's party given slot.
     * @param partySlot slot to be searched
     * @return character stored in that slot
     */
    IPlayableCharacter getCharacterFromParty(int partySlot);

    /**
     * Returns the weapon located in the player's inventory given slot.
     * @param inventorySlot slot to be searched
     * @return weapon stored in that slot
     */
    IWeapon getWeaponFromInventory(int inventorySlot);

    /**
     * Equips a character from the this player's party with a weapon from
     * the inventory.
     * @param inventorySlot slot where the weapon will be taken from
     * @param partySlot slot where the the character is located
     */
    void equipWeaponToCharacter(int inventorySlot, int partySlot);

    /**
     * Makes a character from the party attack other character.
     * @param partySlot party slot where the a ttacking character is located
     * @param character character to be attacked
     */
    void charAttack(int partySlot, ICharacter character);

}

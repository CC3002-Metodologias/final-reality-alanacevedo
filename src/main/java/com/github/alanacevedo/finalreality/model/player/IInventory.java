package com.github.alanacevedo.finalreality.model.player;

import com.github.alanacevedo.finalreality.model.weapon.IWeapon;

public interface IInventory {

    /**
     * Adds a weapon to the inventory. If the inventory is full, doesn't add it.
     * @param weapon weapon to be added
     */
    void addWeapon(IWeapon weapon);

    /**
     * Removes from the inventory the first appearance of the given weapon.
     * @param weapon weapon to be removed
     */
    void removeWeapon(IWeapon weapon);

    /**
     * Returns the current amount of weapons in the inventory.
     */
    int getCurrentSize();

    /**
     * Returns the weapon stored in a given slot from the inventory.
     */
    IWeapon getWeapon(int slot);

    /**
     * Swaps weapons from 2 slots. Can be used to move a weapon from a slot to
     * an empty one.
     * @param slot1 first inventory slot
     * @param slot2 second inventory slot
     */
    void swapItems(int slot1, int slot2);
}

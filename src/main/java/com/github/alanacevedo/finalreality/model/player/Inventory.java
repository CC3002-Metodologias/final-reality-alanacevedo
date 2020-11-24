package com.github.alanacevedo.finalreality.model.player;

import com.github.alanacevedo.finalreality.model.weapon.IWeapon;
import com.github.alanacevedo.finalreality.controller.Settings;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A class that represents the player's inventory
 * @author <M. Alan Acevedo Salazar>
 */
public class Inventory {
    private ArrayList<IWeapon> weaponList;
    private final int maxSize = Settings.inventorySize;

    /**
     * Creates an inventory containing the weapons given in args;
     * @param args array of weapons.
     */
    public Inventory(IWeapon... args) {
        weaponList = new ArrayList<>(); // empty
        for (IWeapon weapon : args) {
            this.addWeapon(weapon);
        }
    }

    /**
     * Adds a weapon to the inventory. If the inventory is full, doesn't add it.
     * @param weapon weapon to be added
     */
    public void addWeapon(IWeapon weapon) {
        if (weaponList.size() < maxSize) {
            this.weaponList.add(weapon);
        }
    }

    /**
     * Removes from the inventory the first appearance of the given weapon.
     * @param weapon weapon to be removed
     */
    public void removeWeapon(IWeapon weapon) {
        weaponList.remove(weapon);
    }

    /**
     * Returns the current amount of weapons in the inventory.
     */
    public int getCurrentSize() {
        return weaponList.size();
    }

    /**
     * Returns the weapon stored in a given slot from the inventory.
     */
    public IWeapon getWeapon(int slot) {
        return weaponList.get(slot);
    }

    public void swapItems(int slot1, int slot2) {
        IWeapon temp = weaponList.get(slot1);
        weaponList.set(slot1, weaponList.get(slot2));
        weaponList.set(slot2, temp);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Inventory)) {
            return false;
        }
        final Inventory inventory = (Inventory) o;

        if (inventory.getCurrentSize() != this.getCurrentSize()) {
            return false;
        }
        for (int i=0; i<this.getCurrentSize(); i++) {
            if (!(inventory.getWeapon(i).equals(this.getWeapon(i)))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponList.toArray());
    }
}

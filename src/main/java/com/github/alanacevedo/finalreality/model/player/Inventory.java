package com.github.alanacevedo.finalreality.model.player;

import com.github.alanacevedo.finalreality.model.weapon.IWeapon;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.model.weapon.NullWeapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A class that represents the player's inventory
 * @author <M. Alan Acevedo Salazar>
 */
public class Inventory implements IInventory {
    private final int maxSize = Settings.inventorySize;
    private IWeapon[] weaponList;
    private int currentSize;

    /**
     * Creates an inventory containing the weapons given in args;
     * @param args array of weapons.
     */
    public Inventory(IWeapon... args) {
        weaponList = new IWeapon[maxSize]; // empty
        Arrays.fill(weaponList, new NullWeapon());
        currentSize = 0;
        for (IWeapon weapon : args) {
            this.addWeapon(weapon);
        }
    }

    @Override
    public void addWeapon(IWeapon weapon) {
        if (currentSize < maxSize && !weapon.isNull()) {
            for (int i=0; i<maxSize; i++) {
                if (weaponList[i].isNull()) {
                    weaponList[i] = weapon;
                    currentSize++;
                    break;
                }
            }
        }
    }

    @Override
    public void removeWeapon(IWeapon weapon) {
        for (int i=0; i<maxSize; i++) {
            if (weaponList[i] == weapon) {
                weaponList[i] = new NullWeapon();
                currentSize--;
                break;
            }
        }
    }

    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public IWeapon getWeapon(int slot) {
        return weaponList[slot];
    }

    @Override
    public void swapItems(int slot1, int slot2) {
        IWeapon temp = weaponList[slot1];
        weaponList[slot1] = weaponList[slot2];
        weaponList[slot2] = temp;
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
                if  (!(inventory.getWeapon(i).equals(this.getWeapon(i)))) {
                    return false;
                }
        }
        return true;
    }

}

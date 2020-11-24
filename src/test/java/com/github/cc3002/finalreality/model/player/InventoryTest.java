package com.github.cc3002.finalreality.model.player;
import com.github.alanacevedo.finalreality.model.player.Inventory;
import com.github.alanacevedo.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InventoryTest {
    Axe weapon1, weapon1Copy;
    Sword weapon2, weapon2Copy;
    Bow weapon3;
    Inventory inventory, copyInventory, diffWeapInventory, diffSizeInventory, emptyInventory;

    @BeforeEach
    public void setUp() {
        weapon1 = new Axe("hacha", 15, 10);
        weapon2 = new Sword("espada", 10, 12);
        weapon1Copy = new Axe("hacha", 15, 10);
        weapon2Copy = new Sword("espada", 10, 12);
        weapon3 = new Bow("arco", 5, 7);
        emptyInventory = new Inventory();
        inventory = new Inventory(weapon1, weapon2);
        copyInventory = new Inventory(weapon1Copy, weapon2Copy);
        diffWeapInventory = new Inventory(weapon1Copy, weapon3);
        diffSizeInventory = new Inventory (weapon1Copy, weapon1Copy, weapon3);

    }

    @Test
    public void constructionTest() {

        assertEquals(inventory.getWeapon(0), copyInventory.getWeapon(0));
        assertEquals(inventory.getWeapon(1), copyInventory.getWeapon(1));
        assertEquals(inventory, copyInventory);
        assertNotEquals(inventory, diffWeapInventory);
        assertNotEquals(inventory, diffSizeInventory);
        assertEquals(0, emptyInventory.getCurrentSize());
        assertEquals(2, copyInventory.getCurrentSize());
        assertEquals(inventory, inventory);
        assertNotEquals(inventory, weapon1);
    }

    @Test
    public void indexFails() {
        assertThrows(IndexOutOfBoundsException.class, () -> inventory.getWeapon(2));
    }

    @Test
    public void swapTest() {
        Inventory swappedInventory = new Inventory(weapon2Copy, weapon1Copy);
        assertNotEquals(inventory, swappedInventory);
        swappedInventory.swapItems(0, 1);
        assertEquals(inventory, swappedInventory);
    }

    @Test
    public void addRemoveTest() {
        Inventory thisInventory = new Inventory();
        assertEquals(emptyInventory, thisInventory);
        thisInventory.addWeapon(weapon1Copy);
        assertNotEquals(thisInventory, emptyInventory);
        assertNotEquals(thisInventory, inventory);
        thisInventory.addWeapon(weapon2Copy);
        assertNotEquals(thisInventory, emptyInventory);
        assertEquals(thisInventory, inventory);
        thisInventory.addWeapon(weapon2Copy);
        assertNotEquals(thisInventory, emptyInventory);
        assertNotEquals(thisInventory, inventory);
        thisInventory.removeWeapon(weapon2Copy);
        assertNotEquals(thisInventory, emptyInventory);
        assertEquals(thisInventory, inventory);
        thisInventory.removeWeapon(weapon2Copy);
        thisInventory.removeWeapon(weapon1Copy);
        assertEquals(thisInventory, emptyInventory);
        assertNotEquals(thisInventory, inventory);

    }
}

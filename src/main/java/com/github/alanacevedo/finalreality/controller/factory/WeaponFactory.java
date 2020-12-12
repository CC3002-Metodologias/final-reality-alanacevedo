package com.github.alanacevedo.finalreality.controller.factory;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.model.weapon.*;

public class WeaponFactory {
    GameController controller;

    public WeaponFactory(GameController controller) {
        this.controller = controller;
    }

    /**
     * Creates an Axe with the given name and adds it to the player's inventory.
     */
    public void addAxeToPlayerInventory(String name, int damage, int weight) {
        Axe weapon = new Axe(name, damage, weight);
        controller.getPlayer().addWeaponToInventory(weapon);
    }

    /**
     * Creates a Knife with the given name and adds it to the player's inventory.
     */
    public void addKnifeToPlayerInventory(String name, int damage, int weight) {
        Knife weapon = new Knife(name, damage, weight);
        controller.getPlayer().addWeaponToInventory(weapon);
    }

    /**
     * Creates a Sword with the given name and adds it to the player's inventory.
     */
    public void addSwordToPlayerInventory(String name, int damage, int weight) {
        Sword weapon = new Sword(name, damage, weight);
        controller.getPlayer().addWeaponToInventory(weapon);
    }

    /**
     * Creates a bow with the given name and adds it to the player's inventory.
     */
    public void addBowToPlayerInventory(String name, int damage, int weight) {
        Bow weapon = new Bow(name, damage, weight);
        controller.getPlayer().addWeaponToInventory(weapon);
    }

    /**
     * Creates a staff with the given name and adds it to the player's inventory.
     */
    public void addStaffToPlayerInventory(String name, int damage, int weight, int magicDamage) {
        Staff weapon = new Staff(name, damage, weight, magicDamage);
        controller.getPlayer().addWeaponToInventory(weapon);
    }
}

package com.github.alanacevedo.finalreality.model.player;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.weapon.IWeapon;

import java.util.Arrays;

/**
 * Class that represents a Final Reality player. Controls a party of characters and manages an inventory.
 */
public class Player implements IPlayer {
    private IInventory inventory = new Inventory();
    private IParty party = new Party();
    String name;

    /**
     * Initializes a player with the given name
     */
    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this("Strategist");
    }

    @Override
    public void addCharacterToParty(IPlayableCharacter character) {
        party.addCharacter(character);
    }

    @Override
    public void addWeaponToInventory(IWeapon weapon) {
        inventory.addWeapon(weapon);
    }

    @Override
    public IWeapon getWeaponFromInventory(int inventorySlot) {
        return inventory.getWeapon(inventorySlot);
    }

    @Override
    public void equipWeaponToCharacter(int inventorySlot, int partySlot) {
        IWeapon weapon = inventory.getWeapon(inventorySlot);
        IWeapon prevWeapon = party.getCharacter(partySlot).getEquippedWeapon();
        party.getCharacter(partySlot).equip(weapon);
        inventory.removeWeapon(weapon);
        if (prevWeapon != null) {
            inventory.addWeapon(prevWeapon);
        }

    }

    @Override
    public void swapInventorySlots(int slot1, int slot2) {
        inventory.swapItems(slot1, slot2);
    }

    @Override
    public void charAttack(int partySlot, ICharacter character) {
        party.getCharacter(partySlot).attack(character);
    }

    @Override
    public IPlayableCharacter getCharacterFromParty(int partySlot) {
        return party.getCharacter(partySlot);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        final Player player = (Player) o;


        return (name.equals(player.name)) && (inventory.equals(player.inventory)) && (party.equals(player.party));
    }
}

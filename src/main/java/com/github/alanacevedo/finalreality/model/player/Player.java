package com.github.alanacevedo.finalreality.model.player;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.weapon.IWeapon;

import java.util.Arrays;

public class Player {
    private Inventory inventory = new Inventory();
    private Party party = new Party();
    String name;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this("Strategist");
    }

    public void addCharacterToParty(IPlayableCharacter character) {
        party.addCharacter(character);
    }

    public void addWeaponToInventory(IWeapon weapon) {
        inventory.addWeapon(weapon);
    }

    public IWeapon getWeaponFromInventory(int inventorySlot) {
        return inventory.getWeapon(inventorySlot);
    }

    public void equipWeaponToCharacter(int inventorySlot, int partySlot) {
        IWeapon weapon = inventory.getWeapon(inventorySlot);
        IWeapon prevWeapon = party.getCharacter(partySlot).getEquippedWeapon();
        party.getCharacter(partySlot).equip(weapon);
        inventory.removeWeapon(weapon);
        if (prevWeapon != null) {
            inventory.addWeapon(prevWeapon);
        }

    }

    public void swapInventorySlots(int slot1, int slot2) {
        inventory.swapItems(slot1, slot2);
    }

    public void charAttack(int partySlot, ICharacter character) {
        party.getCharacter(partySlot).attack(character);
    }

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

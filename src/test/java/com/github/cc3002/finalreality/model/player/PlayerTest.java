package com.github.cc3002.finalreality.model.player;
import static org.junit.jupiter.api.Assertions.*;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;
import com.github.alanacevedo.finalreality.model.player.Inventory;
import com.github.alanacevedo.finalreality.model.player.Party;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.model.player.Player;
import com.github.alanacevedo.finalreality.model.weapon.Bow;
import com.github.alanacevedo.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PlayerTest {
    Player player, playerCopy;
    Inventory inventory;
    Party party;
    BlockingQueue<ICharacter> turnsQueue;

    @BeforeEach
    void setUp() {
        player = new Player();
        playerCopy = new Player();
        turnsQueue = new LinkedBlockingQueue<>();
    }

    @Test
    void constructorTest() {
        Player otherPlayer = new Player("hola");
        Knight char1 = new Knight("caballero", turnsQueue);
        Bow weapon1 = new Bow("arco", 3, 2);
        assertNotEquals(player, otherPlayer);
        assertEquals(player, player);
        assertEquals(player, playerCopy);
        assertNotEquals(player,inventory);
        player.addCharacterToParty(char1);
        assertEquals(char1, player.getCharacterFromParty(0));
        assertNotEquals(player, playerCopy);
        playerCopy.addCharacterToParty(char1);
        assertEquals(player, playerCopy);
        player.addWeaponToInventory(weapon1);
        assertEquals(weapon1, player.getWeaponFromInventory(0));
        assertNotEquals(player, playerCopy);
        playerCopy.addWeaponToInventory(weapon1);
        assertEquals(player, playerCopy);
    }

    @Test
    void swapItemTest() {
        Bow weapon1 = new Bow("arco1", 3, 2);
        Bow weapon2 = new Bow("arco2", 3, 2);
        Bow weapon3 = new Bow("arco3", 3, 2);

        player.addWeaponToInventory(weapon1);
        player.addWeaponToInventory(weapon2);
        player.addWeaponToInventory(weapon3);

        playerCopy.addWeaponToInventory(weapon3);
        playerCopy.addWeaponToInventory(weapon2);
        playerCopy.addWeaponToInventory(weapon1);

        assertNotEquals(player, playerCopy);
        player.swapInventorySlots(0, 2);
        assertEquals(player, playerCopy);
    }

    @Test
    void equipWeaponTest() {
        Knight char1 = new Knight("hola", turnsQueue,  3, 2);
        Knight char1Copy = new Knight("hola", turnsQueue,  3, 2);
        Sword weapon1 = new Sword("arco1", 3, 2);
        Sword weapon2 = new Sword("arco2", 3, 2);
        Sword weapon3 = new Sword("arco3", 3, 2);

        player.addWeaponToInventory(weapon1);
        player.addWeaponToInventory(weapon2);
        player.addWeaponToInventory(weapon3);
        player.addCharacterToParty(char1);

        player.equipWeaponToCharacter(1, 0);

        playerCopy.addWeaponToInventory(weapon1);
        playerCopy.addWeaponToInventory(weapon3);
        playerCopy.swapInventorySlots(1, 2);

        char1Copy.equip(weapon2);
        playerCopy.addCharacterToParty(char1Copy);
        assertEquals(player, playerCopy);

        player.equipWeaponToCharacter(2, 0);

        playerCopy = new Player();
        playerCopy.addWeaponToInventory(weapon1);
        playerCopy.addWeaponToInventory(weapon2);
        char1Copy = new Knight("hola", turnsQueue,  3, 2);
        char1Copy.equip(weapon3);
        playerCopy.addCharacterToParty(char1Copy);

        assertEquals(player, playerCopy);
    }

    @Test
    void attackTest() {
        Knight char1 = new Knight("hola", turnsQueue,  3, 2);
        Knight char2 = new Knight("hola2", turnsQueue, 10, 2);
        Sword weapon1 = new Sword("arco1", 3, 2);

        player.addCharacterToParty(char1);
        player.addWeaponToInventory(weapon1);
        player.equipWeaponToCharacter(0, 0);
        player.charAttack(0, char2);

        assertNotEquals(char2.getHP(), 10);
        assertEquals(char2.getHP(), 9);
    }

}

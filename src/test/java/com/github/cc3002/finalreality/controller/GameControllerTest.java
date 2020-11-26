package com.github.cc3002.finalreality.controller;
import static org.junit.jupiter.api.Assertions.*;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;
import com.github.alanacevedo.finalreality.model.player.Inventory;
import com.github.alanacevedo.finalreality.model.player.Party;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.model.player.Player;
import com.github.alanacevedo.finalreality.model.weapon.Axe;
import com.github.alanacevedo.finalreality.model.weapon.Bow;
import com.github.alanacevedo.finalreality.model.weapon.Knife;
import com.github.alanacevedo.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameControllerTest {

    GameController controller;

    @BeforeEach
    void setUp() {
        controller = new GameController();
    }

    @Test
    void addCharacterToPartyTest() {
        var turnsQueue = controller.getTurnsQueue();
        BlackMage blackMage = new BlackMage("maguito", turnsQueue);
        controller.addBlackMageToPlayerParty("maguito");
        assertEquals(controller.getPlayer().getCharacterFromParty(0), blackMage);

        controller.addEngineerToPlayerParty("engi");
        controller.addKnightToPlayerParty("caballero");
        controller = new GameController();
        controller.addWhiteMageToPlayerParty("maguito2");
        controller.addThiefToPlayerParty("ladroncito");
    }

    @Test
    void addWeaponToInventoryTest() {
        Axe axe = new Axe("hacha", 30, 12);
        controller.addAxeToPlayerInventory("hacha", 30, 12);
        assertEquals(controller.getPlayer().getWeaponFromInventory(0), axe);
        controller.addBowToPlayerInventory("bow", 1, 1);
        controller.addStaffToPlayerInventory("palo", 3, 2, 1);
        controller.addSwordToPlayerInventory("palito", 12, 1);
        controller.addKnifeToPlayerInventory("cuchillo", 12, 11);
        Knife knife = new Knife("cuchillo", 12, 11);
        assertEquals(controller.getPlayer().getWeaponFromInventory(4), knife);
        controller.swapInventorySlots(0, 4);
        assertEquals(controller.getPlayer().getWeaponFromInventory(4), axe);
    }

    @Test
    void attackTest() {
        controller.spawnEnemyGroup(40, 3, "uno", "dos", "tres");
        controller.addSwordToPlayerInventory("espada", 200, 10);
        controller.addKnightToPlayerParty("caballero");
        controller.equipWeaponToCharacter(0,0);

        controller.EnemyAttackPChar(0, 0);
        int knightCurrentHp = controller.getPlayer().getCharacterFromParty(0).getHP();
        int knightMaxHp = controller.getPlayer().getCharacterFromParty(0).getMaxHP();
        assertNotEquals(knightCurrentHp, knightMaxHp);

        controller.PCharAttackEnemy(0, 0);
        int enemyCurrentHp = controller.getEnemyGroup().getEnemy(0).getHP();
        int enemyMaxHp = controller.getEnemyGroup().getEnemy(0).getMaxHP();
        assertNotEquals(enemyCurrentHp, enemyMaxHp);

    }
}

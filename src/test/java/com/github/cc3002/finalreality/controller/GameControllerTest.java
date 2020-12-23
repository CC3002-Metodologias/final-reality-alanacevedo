package com.github.cc3002.finalreality.controller;
import static org.junit.jupiter.api.Assertions.*;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;
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
    void standardSetupTest() {
        controller.setupStandardBattle();
        assertTrue(controller.isBattleActive());
        controller.endBattle();
        assertFalse(controller.isBattleActive());
    }

    @Test
    void enemyDeathTest() {
        controller.setupStandardBattle();
        assertTrue(controller.isBattleActive());
        controller.enemyDeath();
        controller.enemyDeath();
        controller.enemyDeath();
        assertFalse(controller.isBattleActive());
    }

    @Test
    void pcharDeathTest() {
        controller.setupStandardBattle();
        assertTrue(controller.isBattleActive());
        controller.playerCharacterDeath();
        controller.playerCharacterDeath();
        controller.playerCharacterDeath();
        assertFalse(controller.isBattleActive());
    }

    @Test
    void enemyTurnTest() {
        controller.setupStandardBattle();
        controller.enemyTurn(controller.getEnemyGroup().getEnemy(0));
        var char0 = controller.getPlayer().getCharacterFromParty(0);
        var char1 = controller.getPlayer().getCharacterFromParty(1);
        var char2 = controller.getPlayer().getCharacterFromParty(2);
        assertTrue(char0.getHP()!=char0.getMaxHP() || char1.getHP()!=char1.getMaxHP() || char2.getHP()!=char2.getMaxHP());
    }

    @Test
    void addToQueueTest() {
        var queue = controller.getTurnsQueue();
        controller.getCharacterFactory().addEngineerToPlayerParty("a");
        controller.addToQueue(controller.getPlayer().getCharacterFromParty(0));
        assertTrue(queue.isEmpty());
        controller = new GameController();
        controller.setupStandardBattle();
        controller.addToQueue(controller.getPlayer().getCharacterFromParty(0));
        controller.addToQueue(controller.getPlayer().getCharacterFromParty(1));
        queue = controller.getTurnsQueue();
        assertFalse(queue.isEmpty());
        controller=new GameController();
        controller.getCharacterFactory().addEngineerToPlayerParty("a");
        controller.getPlayer().getCharacterFromParty(0).receiveDamage(500);
        assertFalse(controller.getPlayer().getCharacterFromParty(0).isAlive());
        controller.addToQueue(controller.getPlayer().getCharacterFromParty(0));
        queue = controller.getTurnsQueue();
        assertTrue(queue.isEmpty());
    }
}

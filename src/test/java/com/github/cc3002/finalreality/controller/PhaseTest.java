package com.github.cc3002.finalreality.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.*;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.Knight;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.WhiteMage;
import com.github.alanacevedo.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhaseTest {
    GameController controller;

    @BeforeEach
    void setUp() {
        controller = new GameController();
    }

    @Test
    void ActionSelectPhaseTest() {
        controller.setPhase(new ActionSelectionPhase(controller));
        assertTrue(controller.getPhase() instanceof ActionSelectionPhase);
        var phase0 = (ActionSelectionPhase) controller.getPhase();
        phase0.getAttackCommand().doAction();
        assertTrue(controller.getPhase() instanceof AttackTargetSelectionPhase);
        var phase1 = (AttackTargetSelectionPhase) controller.getPhase();
        phase1.getGoBackCommand().doAction();
        assertTrue(controller.getPhase() instanceof ActionSelectionPhase);
        phase0 = (ActionSelectionPhase) controller.getPhase();
        phase0.getInventoryCommand().doAction();
        assertTrue(controller.getPhase() instanceof InventoryPhase);
        var phase2 = (InventoryPhase) controller.getPhase();
        phase2.getGoBackCommand().doAction();
        assertTrue(controller.getPhase() instanceof ActionSelectionPhase);
        phase0 = (ActionSelectionPhase) controller.getPhase();
        phase0.getMagicCommand().doAction(); // Shouldn't be able to select this option
        assertTrue(controller.getPhase() instanceof ActionSelectionPhase);
    }

    /*
    @Test
    void MageActionSelectPhaseTest() {
        controller.setPhase(new MageActionSelectionPhase(controller));
        assertTrue(controller.getPhase() instanceof MageActionSelectionPhase);
        var phase0 = (MageActionSelectionPhase) controller.getPhase();
        phase0.getAttackCommand().doAction();
        assertTrue(controller.getPhase() instanceof MageAttackTargetSelectionPhase);
        var phase1 = (MageAttackTargetSelectionPhase) controller.getPhase();
        phase1.getGoBackCommand().doAction();
        assertTrue(controller.getPhase() instanceof MageActionSelectionPhase);
        phase0 = (MageActionSelectionPhase) controller.getPhase();
        phase0.getInventoryCommand().doAction();
        assertTrue(controller.getPhase() instanceof MageInventoryPhase);
        var phase2 = (MageInventoryPhase) controller.getPhase();
        phase2.getGoBackCommand().doAction();
        assertTrue(controller.getPhase() instanceof MageActionSelectionPhase);
        phase0 = (MageActionSelectionPhase) controller.getPhase();
        phase0.getMagicCommand().doAction(); // Should be able to select this option
        assertTrue(controller.getPhase() instanceof MagicSelectionPhase);
        var phase3 = (MagicSelectionPhase) controller.getPhase();
        phase3.getGoBackCommand().doAction();
        assertTrue(controller.getPhase() instanceof MageActionSelectionPhase);
    }
    */
    @Test
    void attackTargetSelectionPhaseTest() {
        controller.spawnEnemyGroup(30, 3, "uno", "dos", "tres");
        controller.addSwordToPlayerInventory("espada1", 50, 14);
        controller.addKnightToPlayerParty("caballero1");
        controller.equipWeaponToCharacter(0,0);

        controller.setCurrentChar(controller.getPlayer().getCharacterFromParty(0));
        controller.setPhase(new ActionSelectionPhase(controller));

        var phase0 = (ActionSelectionPhase) controller.getPhase();
        phase0.getAttackCommand().doAction();

        var phase1 = (AttackTargetSelectionPhase) controller.getPhase();
        assertEquals(controller.getEnemyGroup().getEnemy(0).getHP(), controller.getEnemyGroup().getEnemy(0).getMaxHP());
        phase1.getAttackCommand0().doAction();
        assertNotEquals(controller.getEnemyGroup().getEnemy(0).getHP(), controller.getEnemyGroup().getEnemy(0).getMaxHP());

        controller.setCurrentChar(controller.getPlayer().getCharacterFromParty(0));
        controller.setPhase(new ActionSelectionPhase(controller));
        phase0 = (ActionSelectionPhase) controller.getPhase();
        phase0.getAttackCommand().doAction();
        phase1 = (AttackTargetSelectionPhase) controller.getPhase();
        assertEquals(controller.getEnemyGroup().getEnemy(1).getHP(), controller.getEnemyGroup().getEnemy(0).getMaxHP());
        phase1.getAttackCommand1().doAction();
        assertNotEquals(controller.getEnemyGroup().getEnemy(1).getHP(), controller.getEnemyGroup().getEnemy(0).getMaxHP());

        controller.setCurrentChar(controller.getPlayer().getCharacterFromParty(0));
        controller.setPhase(new ActionSelectionPhase(controller));
        phase0 = (ActionSelectionPhase) controller.getPhase();
        phase0.getAttackCommand().doAction();
        phase1 = (AttackTargetSelectionPhase) controller.getPhase();
        assertEquals(controller.getEnemyGroup().getEnemy(2).getHP(), controller.getEnemyGroup().getEnemy(0).getMaxHP());
        phase1.getAttackCommand2().doAction();
        assertNotEquals(controller.getEnemyGroup().getEnemy(2).getHP(), controller.getEnemyGroup().getEnemy(0).getMaxHP());

    }

    @Test
    void InventoryEquipTest () {
        controller.addSwordToPlayerInventory("espada0", 50, 14);
        controller.addSwordToPlayerInventory("espada1", 50, 14);
        controller.addSwordToPlayerInventory("espada2", 50, 14);
        controller.addSwordToPlayerInventory("espada3", 50, 14);
        controller.addSwordToPlayerInventory("espada4", 50, 14);
        controller.addKnightToPlayerParty("caballero1");

        controller.setPhase(new InventoryPhase(controller));
        controller.setCurrentChar(controller.getPlayer().getCharacterFromParty(0));
        IPlayableCharacter knight = controller.getPlayer().getCharacterFromParty(0);
        Sword sword0 = new Sword("espada0", 50, 14);
        assertNull(knight.getEquippedWeapon());
        assertEquals(controller.getPlayer().getWeaponFromInventory(0), sword0);

        // We equip the weapon stored in slot 0. Because knight doesn't have a weapon equipped,
        // slot 0 now has <null> stored. Knight should now have the sword equipped.
        ((InventoryPhase) controller.getPhase()).getHighlightCommand0().doAction();
        ((InventoryPhase) controller.getPhase()).getEquipCommand().doAction();
        assertEquals(knight.getEquippedWeapon(), sword0);
        assertNull(controller.getPlayer().getWeaponFromInventory(0));

        // We scroll down
        ((InventoryPhase) controller.getPhase()).getScrollDownCommand().doAction();
        ((InventoryPhase) controller.getPhase()).getHighlightCommand2().doAction();
        //  HLCommand2 is selected, points to inventory slot 3.
        Sword sword3 = new Sword("espada3", 50, 14);
        assertEquals(controller.getPlayer().getWeaponFromInventory(3), sword3);
        assertNull(controller.getPlayer().getWeaponFromInventory(0));
        ((InventoryPhase) controller.getPhase()).getEquipCommand().doAction();

        // Now knight should have sword3 equipped. Inventory slot 3 should now be empty, and
        // slot 0 should now have sword0 stored.

        assertEquals(knight.getEquippedWeapon(), sword3);
        assertEquals(sword0, controller.getPlayer().getWeaponFromInventory(0));
        assertNull(controller.getPlayer().getWeaponFromInventory(3));

        // test for scrolldown limit
        for (int i=0; i < 2*Settings.inventorySize; i++) {
            ((InventoryPhase) controller.getPhase()).getScrollDownCommand().doAction();
        }
        ((InventoryPhase) controller.getPhase()).getHighlightCommand2().doAction();
        assertEquals(Settings.inventorySize-1, ((InventoryPhase) controller.getPhase()).getHighlightedSlot());

        // test for scrollup limit
        for (int i=0; i < 2*Settings.inventorySize; i++) {
            ((InventoryPhase) controller.getPhase()).getScrollUpCommand().doAction();
        }
        ((InventoryPhase) controller.getPhase()).getHighlightCommand2().doAction();
        assertEquals(2, ((InventoryPhase) controller.getPhase()).getHighlightedSlot());
    }

    @Test
    void InventorySwapPhaseTest () {
        controller.addSwordToPlayerInventory("espada0", 50, 14);
        controller.addSwordToPlayerInventory("espada1", 50, 14);
        controller.addSwordToPlayerInventory("espada2", 50, 14);
        controller.addSwordToPlayerInventory("espada3", 50, 14);
        controller.addSwordToPlayerInventory("espada4", 50, 14);
        controller.addKnightToPlayerParty("caballero1");
        controller.setPhase(new InventoryPhase(controller));
        controller.setCurrentChar(controller.getPlayer().getCharacterFromParty(0));
        Sword sword1 = new Sword("espada1", 50, 14);
        Sword sword3 = new Sword("espada3", 50, 14);
        IPlayableCharacter knight = controller.getPlayer().getCharacterFromParty(0);

        assertEquals(sword1, controller.getPlayer().getWeaponFromInventory(1));
        assertEquals(sword3, controller.getPlayer().getWeaponFromInventory(3));

        // We highlight slot 1 and then hit swap option
        ((InventoryPhase) controller.getPhase()).getHighlightCommand1().doAction();
        assertEquals(1, (((InventoryPhase) controller.getPhase()).getHighlightedSlot()));
        ((InventoryPhase) controller.getPhase()).getSwapCommand().doAction();
        // We check that we are in swap phase
        assertTrue(controller.getPhase() instanceof InventorySwapPhase);
        assertEquals(1, ((InventorySwapPhase) controller.getPhase()).getFirstSlot());
        // We select slot 3 and then hit confirm swap option.
        ((InventorySwapPhase) controller.getPhase()).getScrollDownCommand().doAction();
        ((InventorySwapPhase) controller.getPhase()).getHighlightCommand2().doAction();
        assertEquals(3, ((InventorySwapPhase) controller.getPhase()).getHighlightedSlot());
        ((InventorySwapPhase) controller.getPhase()).getConfirmSwapCommand().doAction();
        // We check that we are back to inventory phase and that the items are swapped
        assertTrue(controller.getPhase() instanceof InventoryPhase);
        assertEquals(sword1, controller.getPlayer().getWeaponFromInventory(3));
        assertEquals(sword3, controller.getPlayer().getWeaponFromInventory(1));


        // test for scrolldown limit
        controller.setPhase(new InventorySwapPhase(controller, 4));
        for (int i=0; i < 2*Settings.inventorySize; i++) {
            ((InventorySwapPhase) controller.getPhase()).getScrollDownCommand().doAction();
        }
        ((InventorySwapPhase) controller.getPhase()).getHighlightCommand2().doAction();
        assertEquals(Settings.inventorySize-1, ((InventorySwapPhase) controller.getPhase()).getHighlightedSlot());

        // test for scrollup limit
        for (int i=0; i < 2*Settings.inventorySize; i++) {
            ((InventorySwapPhase) controller.getPhase()).getScrollUpCommand().doAction();
        }
        ((InventorySwapPhase) controller.getPhase()).getHighlightCommand2().doAction();
        assertEquals(2, ((InventorySwapPhase) controller.getPhase()).getHighlightedSlot());
    }

    @Test
    void MagicPhaseTest() {
        controller.setPhase(new ActionSelectionPhase(controller));
        controller.addKnightToPlayerParty("hola");
        controller.addWhiteMageToPlayerParty("chao");
        controller.setCurrentChar(controller.getPlayer().getCharacterFromParty(0));
        assertTrue(controller.getCurrentChar() instanceof Knight);
        ((ActionSelectionPhase) controller.getPhase()).getMagicCommand().doAction();
        // A knight is not a mage, so magic option shouldn't work
        assertTrue(controller.getPhase() instanceof ActionSelectionPhase);

        // Now we try with a mage
        controller.setCurrentChar(controller.getPlayer().getCharacterFromParty(1));
        assertTrue(controller.getCurrentChar() instanceof WhiteMage);
        assertTrue(controller.getCurrentChar().isMage());
        ((ActionSelectionPhase) controller.getPhase()).getMagicCommand().doAction();
        assertTrue(controller.getPhase() instanceof MagicSelectionPhase);
    }
}

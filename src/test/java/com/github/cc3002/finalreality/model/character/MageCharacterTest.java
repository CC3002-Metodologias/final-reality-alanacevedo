package com.github.cc3002.finalreality.model.character;

import com.github.alanacevedo.finalreality.model.character.player.AbsMageCharacter;

import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Set of tests for Mage classes.
 *
 * @author Ignacio Slater Muñoz.
 * @author <M. Alan Acevedo Salazar>
 * @see AbsMageCharacter
 */

public class MageCharacterTest extends PlayerCharacterTest{

    @Test
    void cureTest() {
        generateCharactersAndWeapons();

        // testKnight maxHP = 100, testBlackMage initialMP = 50;
        assertEquals(testWhiteMage.getMP(), 50);
        assertEquals(testKnight.getHP(), 100);
        testKnight.receiveDamage(50); // HP = 50
        testWhiteMage.castCure(testKnight); // 30% of 100 is 30
        assertEquals(testKnight.getHP(), 80); // 50 + 30 = 80
        testWhiteMage.castCure(testKnight); 
        assertEquals(testKnight.getHP(), 100); // 83 + 30 = 113 but maxHP is 100
        assertTrue(testKnight.isAlive());
        testKnight.receiveDamage(120);
        assertEquals(testKnight.getHP(), 0);
        assertFalse(testKnight.isAlive());
        testWhiteMage.castCure(testKnight); //If a character is dead, he shouldn't be healed.
        assertEquals(testKnight.getHP(), 0);
        assertFalse(testKnight.isAlive());

        // Until now Cure has been successfully cast 2 times, so testBlackMage has 5 MP left and
        // should be able to cast it just one more time.

        testEngineer.receiveDamage(50); // MaxHP = 100
        testWhiteMage.castCure(testEngineer);
        assertEquals(testEngineer.getHP(), 80);
        assertEquals(testWhiteMage.getMP(), 5);
        testWhiteMage.castCure(testEngineer); // He's at 80 HP now, and only 5 mp left
        assertEquals(testEngineer.getHP(), 80); // cure shouldn't heal
        assertEquals(testWhiteMage.getMP(), 5);

        // Testing if a dead Mage can cast Cure

        testWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, testHP, testDEF, testMP); // MP = 50;
        testWhiteMage.receiveDamage(200); // Killed
        assertFalse(testWhiteMage.isAlive());
        testWhiteMage.castCure(testEngineer); // Shouldn't cast
        assertEquals(testEngineer.getHP(), 80);

    }

    @Test
    void fireTest() {
        generateCharactersAndWeapons();
        assertEquals(testKnight.getHP(), 100);
        assertNull(testBlackMage.getEquippedWeapon());
        testBlackMage.castFire(testKnight); // Si no tiene arma equipada no debería poder castear
        testBlackMage.equip(testStaff); // magicDamage = 10;
        testBlackMage.castFire(testKnight);
        assertEquals(testKnight.getHP(), 90); // MP = 35
        testKnight.receiveDamage(85);
        assertEquals(testKnight.getHP(), 5);
        assertTrue(testKnight.isAlive());
        testBlackMage.castFire(testKnight); // MP = 20
        assertEquals(testKnight.getHP(), 0);
        assertFalse(testKnight.isAlive());
        testBlackMage.castFire(testKnight); // Objetivo muerto, no debería castear
        assertEquals(testKnight.getHP(), 0);
        assertFalse(testKnight.isAlive());
        assertEquals(testBlackMage.getMP(), 20);

        testEngineer.receiveDamage(50); // HP = 50/100
        testBlackMage.spendMP(15);
        testBlackMage.castFire(testEngineer); // Shouldn't be cast because out of mana.
        assertEquals(testEngineer.getHP(), 50);

        testBlackMage = new BlackMage(WHITE_MAGE_NAME, turns, testHP, testDEF, testMP); // MP = 50;
        testBlackMage.receiveDamage(200); // Killed
        assertFalse(testBlackMage.isAlive());
        testBlackMage.castFire(testEngineer); // Shouldn't be cast
        assertEquals(testEngineer.getHP(), 50);
        assertEquals(testBlackMage.getMP(), 50);

    }

    @Test
    void thunderTest() {
        generateCharactersAndWeapons();
        assertEquals(testKnight.getHP(), 100);
        assertNull(testBlackMage.getEquippedWeapon());
        testBlackMage.castThunder(testKnight); // Si no tiene arma equipada no debería poder castear
        testBlackMage.equip(testStaff); // magicDamage = 10;
        testBlackMage.castThunder(testKnight);
        assertEquals(testKnight.getHP(), 90); // MP = 35
        testKnight.receiveDamage(85);
        assertEquals(testKnight.getHP(), 5);
        assertTrue(testKnight.isAlive());
        testBlackMage.castThunder(testKnight); // MP = 20
        assertEquals(testKnight.getHP(), 0);
        assertFalse(testKnight.isAlive());
        testBlackMage.castThunder(testKnight); // Objetivo muerto, no debería castear
        assertEquals(testKnight.getHP(), 0);
        assertFalse(testKnight.isAlive());
        assertEquals(testBlackMage.getMP(), 20);

        testEngineer.receiveDamage(50); // HP = 50/100
        testBlackMage.spendMP(15);
        testBlackMage.castThunder(testEngineer); // Shouldn't be cast because out of mana.
        assertEquals(testEngineer.getHP(), 50);

        testBlackMage = new BlackMage(WHITE_MAGE_NAME, turns, testHP, testDEF, testMP); // MP = 50;
        testBlackMage.receiveDamage(200); // Killed
        assertFalse(testBlackMage.isAlive());
        testBlackMage.castThunder(testEngineer); // Shouldn't be cast
        assertEquals(testEngineer.getHP(), 50);
        assertEquals(testBlackMage.getMP(), 50);

    }
}

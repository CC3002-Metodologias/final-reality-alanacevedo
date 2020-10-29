package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.alanacevedo.finalreality.model.character.AbstractCharacter;
import com.github.alanacevedo.finalreality.model.character.Enemy;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.character.player.AbsPlayerCharacter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;
import com.github.alanacevedo.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Set of tests for the {@code AbsPlayerCharacter} class.
 *
 * @author Ignacio Slater Muñoz.
 * @author <M. Alan Acevedo Salazar>
 * @see AbsPlayerCharacter
 */
class PlayerCharacterTest extends AbsCharacterTest {


  private Map <CharacterClass, AbstractCharacter> characters;
  private Map <CharacterClass, AbstractCharacter> charactersCopy;
  private Map <CharacterClass, AbstractCharacter> charactersDiff;

  /**
   * Setup method.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    BlackMage testBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, testHP, testDEF, testMP);
    Knight testKnight = new Knight(KNIGHT_NAME, turns, testHP, testDEF);
    Thief testThief = new Thief(THIEF_NAME, turns, testHP, testDEF);
    Engineer testEngineer = new Engineer(ENGINEER_NAME, turns, testHP, testDEF);
    WhiteMage testWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, testHP, testDEF, testMP);

    characters = new EnumMap<>(CharacterClass.class);
    characters.put(CharacterClass.BLACK_MAGE, testBlackMage);
    characters.put(CharacterClass.KNIGHT, testKnight);
    characters.put(CharacterClass.THIEF, testThief);
    characters.put(CharacterClass.ENGINEER, testEngineer);
    characters.put(CharacterClass.WHITE_MAGE, testWhiteMage);

    charactersCopy = new EnumMap<>(CharacterClass.class);
    charactersCopy.put(CharacterClass.BLACK_MAGE, new BlackMage(BLACK_MAGE_NAME, turns, testHP, testDEF, testMP));
    charactersCopy.put(CharacterClass.KNIGHT, new Knight(KNIGHT_NAME, turns, testHP, testDEF));
    charactersCopy.put(CharacterClass.THIEF, new Thief(THIEF_NAME, turns, testHP, testDEF));
    charactersCopy.put(CharacterClass.ENGINEER, new Engineer(ENGINEER_NAME, turns, testHP, testDEF));
    charactersCopy.put(CharacterClass.WHITE_MAGE,new WhiteMage(WHITE_MAGE_NAME, turns, testHP, testDEF, testMP));


    charactersDiff = new EnumMap<>(CharacterClass.class);
    charactersDiff.put(CharacterClass.BLACK_MAGE, new BlackMage("Charlie", turns));
    charactersDiff.put(CharacterClass.KNIGHT, new Knight("Charlie", turns));
    charactersDiff.put(CharacterClass.THIEF, new Thief("Charlie", turns));
    charactersDiff.put(CharacterClass.ENGINEER, new Engineer("Charlie", turns));
    charactersDiff.put(CharacterClass.WHITE_MAGE,new WhiteMage("Charlie", turns));

  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */

  @Test
  void constructorTest(){
    for (var charClass : CharacterClass.values()){
      var expected = characters.get(charClass);
      var equal = charactersCopy.get(charClass);
      var diff = charactersDiff.get(charClass);
      var other = charClass == CharacterClass.THIEF ?
              characters.get(CharacterClass.KNIGHT) : characters.get(CharacterClass.THIEF);

      checkConstruction(expected, equal, diff, other);

      //checkeando unos casos que se escapan
      assertNotEquals(expected, new Enemy("esqueletito", 2, turns, 3, 3, 3));
    }
  }


  @Test
  void whiteMageTest(){
    var expectedMage = new WhiteMage(WHITE_MAGE_NAME,turns, testHP, testDEF, testMP);
    var difCLASS =new BlackMage(WHITE_MAGE_NAME,turns, testHP, testDEF, testMP);
    var difHP = new WhiteMage(WHITE_MAGE_NAME,turns, 99, testDEF, testMP);
    var difMP = new WhiteMage(WHITE_MAGE_NAME,turns, testHP, testDEF, 99);
    var difDEF = new WhiteMage(WHITE_MAGE_NAME,turns, testHP, 99, testMP);

    assertNotEquals(expectedMage, difHP);
    assertNotEquals(expectedMage, difMP);
    assertNotEquals(expectedMage, difDEF);
    assertNotEquals(expectedMage, difCLASS);
  }

  @Test
  void blackMageTest(){
    var expectedMage = new BlackMage(WHITE_MAGE_NAME,turns, testHP, testDEF, testMP);
    var difCLASS =new WhiteMage(WHITE_MAGE_NAME,turns, testHP, testDEF, testMP);
    var difHP = new BlackMage(WHITE_MAGE_NAME,turns, 99, testDEF, testMP);
    var difMP = new BlackMage(WHITE_MAGE_NAME,turns, testHP, testDEF, 99);
    var difDEF = new BlackMage(WHITE_MAGE_NAME,turns, testHP, 99, testMP);

    assertNotEquals(expectedMage, difHP);
    assertNotEquals(expectedMage, difMP);
    assertNotEquals(expectedMage, difDEF);
    assertNotEquals(expectedMage, difCLASS);
  }

  @Test
  void knightTest(){
    var expectedChar = new Knight(WHITE_MAGE_NAME,turns, testHP, testDEF);
    var difCLASS =new Thief(WHITE_MAGE_NAME,turns, testHP, testDEF);
    var difHP = new Knight(WHITE_MAGE_NAME,turns, 99, testDEF);
    var difDEF = new Knight(WHITE_MAGE_NAME,turns, testHP, 99);

    assertNotEquals(expectedChar, difHP);
    assertNotEquals(expectedChar, difDEF);
    assertNotEquals(expectedChar, difCLASS);
  }

  @Test
  void thiefTest(){
    var expectedChar = new Thief(WHITE_MAGE_NAME,turns, testHP, testDEF);
    var difCLASS =new Knight(WHITE_MAGE_NAME,turns, testHP, testDEF);
    var difHP = new Thief(WHITE_MAGE_NAME,turns, 99, testDEF);
    var difDEF = new Thief(WHITE_MAGE_NAME,turns, testHP, 99);

    assertNotEquals(expectedChar, difHP);
    assertNotEquals(expectedChar, difDEF);
    assertNotEquals(expectedChar, difCLASS);
  }

  @Test
  void engineerTest(){
    var expectedChar = new Engineer(WHITE_MAGE_NAME,turns, testHP, testDEF);
    var difCLASS =new Thief(WHITE_MAGE_NAME,turns, testHP, testDEF);
    var difHP = new Engineer(WHITE_MAGE_NAME,turns, 99, testDEF);
    var difDEF = new Engineer(WHITE_MAGE_NAME,turns, testHP, 99);

    assertNotEquals(expectedChar, difHP);
    assertNotEquals(expectedChar, difDEF);
    assertNotEquals(expectedChar, difCLASS);
  }


  // Test equipar armas
  @Test
  void equipWeaponTest() {
    generateCharactersAndWeapons();

    // Test equipar armas a Knight. Debería sólo poder equipar Sword, Axe, Knife.

    // En un comienzo no debería tener un arma equipada
    assertNull(testKnight.getEquippedWeapon());
    testKnight.equip(testAxe);
    assertEquals(testKnight.getEquippedWeapon(), testAxe);
    testKnight.equip(testSword);
    assertEquals(testKnight.getEquippedWeapon(), testSword);
    testKnight.equip(testKnife);
    assertEquals(testKnight.getEquippedWeapon(), testKnife);
    testKnight.equip(testBow);
    assertEquals(testKnight.getEquippedWeapon(), testKnife);
    assertNotEquals(testKnight.getEquippedWeapon(), testBow);
    testKnight.equip(testStaff);
    assertEquals(testKnight.getEquippedWeapon(), testKnife);
    assertNotEquals(testKnight.getEquippedWeapon(), testStaff);

    // Test equipar armas a Engineer. Debería sólo poder equipar Axe, Bow.

    assertNull(testEngineer.getEquippedWeapon());
    testEngineer.equip(testAxe);
    assertEquals(testEngineer.getEquippedWeapon(), testAxe);
    testEngineer.equip(testSword);
    assertNotEquals(testEngineer.getEquippedWeapon(), testSword);
    assertEquals(testEngineer.getEquippedWeapon(), testAxe);
    testEngineer.equip(testKnife);
    assertNotEquals(testEngineer.getEquippedWeapon(), testKnife);
    assertEquals(testEngineer.getEquippedWeapon(), testAxe);
    testEngineer.equip(testBow);
    assertEquals(testEngineer.getEquippedWeapon(), testBow);
    testEngineer.equip(testStaff);
    assertNotEquals(testEngineer.getEquippedWeapon(), testStaff);
    assertEquals(testEngineer.getEquippedWeapon(), testBow);

    // Test equipar armas a Thief. Debería sólo poder equipar Sword, Knife, Bow.

    assertNull(testThief.getEquippedWeapon());
    testThief.equip(testAxe);
    assertNull(testThief.getEquippedWeapon());
    assertNotEquals(testThief.getEquippedWeapon(), testAxe);
    testThief.equip(testSword);
    assertEquals(testThief.getEquippedWeapon(), testSword);
    testThief.equip(testKnife);
    assertEquals(testThief.getEquippedWeapon(), testKnife);
    assertNotEquals(testThief.getEquippedWeapon(), testSword);
    testThief.equip(testBow);
    assertEquals(testThief.getEquippedWeapon(), testBow);
    assertNotEquals(testThief.getEquippedWeapon(), testKnife);
    testThief.equip(testStaff);
    assertEquals(testThief.getEquippedWeapon(), testBow);
    assertNotEquals(testThief.getEquippedWeapon(), testStaff);

    // Test equipar armas a BlackMage. Debería poder equipar Knife, Staff.

    assertNull(testBlackMage.getEquippedWeapon());
    testBlackMage.equip(testAxe);
    assertNull(testBlackMage.getEquippedWeapon());
    testBlackMage.equip(testSword);
    assertNull(testBlackMage.getEquippedWeapon());
    testBlackMage.equip(testKnife);
    assertEquals(testBlackMage.getEquippedWeapon(), testKnife);
    testBlackMage.equip(testBow);
    assertNotEquals(testBlackMage.getEquippedWeapon(), testBow);
    assertEquals(testBlackMage.getEquippedWeapon(), testKnife);
    testBlackMage.equip(testStaff);
    assertNotEquals(testBlackMage.getEquippedWeapon(), testKnife);
    assertEquals(testBlackMage.getEquippedWeapon(), testStaff);

    // Test equipar armas a WhiteMage. Debería poder equipar Staff.

    assertNull(testWhiteMage.getEquippedWeapon());
    testWhiteMage.equip(testAxe);
    assertNull(testWhiteMage.getEquippedWeapon());
    testWhiteMage.equip(testSword);
    assertNull(testWhiteMage.getEquippedWeapon());
    testWhiteMage.equip(testKnife);
    assertNull(testWhiteMage.getEquippedWeapon());
    testWhiteMage.equip(testBow);
    assertNull(testWhiteMage.getEquippedWeapon());
    testWhiteMage.equip(testStaff);
    assertEquals(testWhiteMage.getEquippedWeapon(), testStaff);

  }


}

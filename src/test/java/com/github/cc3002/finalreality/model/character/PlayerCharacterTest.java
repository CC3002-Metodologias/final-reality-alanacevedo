package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.alanacevedo.finalreality.model.character.AbstractCharacter;
import com.github.alanacevedo.finalreality.model.character.Enemy;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.character.player.AbsPlayerCharacter;

import java.util.EnumMap;
import java.util.Map;

import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;
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
  private static final String BLACK_MAGE_NAME = "Vivi";
  private static final String KNIGHT_NAME = "Adelbert";
  private static final String WHITE_MAGE_NAME = "Eiko";
  private static final String ENGINEER_NAME = "Cid";
  private static final String THIEF_NAME = "Zidane";
  private static final String ENEMY_NAME = "Skeleton";
  int testHP = 100;
  int testDEF = 50;
  int testMP = 80;
  int testWeight = 5;
  int testATK = 20;

  private Map <CharacterClass, AbstractCharacter> characters;
  private Map <CharacterClass, AbstractCharacter> charactersCopy;
  private Map <CharacterClass, AbstractCharacter> charactersDiff;


  /**
   * Setup method.
   * Creates a new character named Vivi with 10 speed and links it to a turn queue.
   */
  @BeforeEach
  void setUp() {
    super.basicSetUp();

    characters = new EnumMap<>(CharacterClass.class);
    characters.put(CharacterClass.BLACK_MAGE, new BlackMage(BLACK_MAGE_NAME, turns, testHP, testDEF, testMP));
    characters.put(CharacterClass.KNIGHT, new Knight(KNIGHT_NAME, turns, testHP, testDEF));
    characters.put(CharacterClass.THIEF, new Thief(THIEF_NAME, turns, testHP, testDEF));
    characters.put(CharacterClass.ENGINEER, new Engineer(ENGINEER_NAME, turns, testHP, testDEF));
    characters.put(CharacterClass.WHITE_MAGE,new WhiteMage(WHITE_MAGE_NAME, turns, testHP, testDEF, testMP));
    characters.put(CharacterClass.ENEMY, new Enemy(ENEMY_NAME, testWeight, turns, testHP, testDEF, testATK ));

    charactersCopy = new EnumMap<>(CharacterClass.class);
    charactersCopy.put(CharacterClass.BLACK_MAGE, new BlackMage(BLACK_MAGE_NAME, turns, testHP, testDEF, testMP));
    charactersCopy.put(CharacterClass.KNIGHT, new Knight(KNIGHT_NAME, turns, testHP, testDEF));
    charactersCopy.put(CharacterClass.THIEF, new Thief(THIEF_NAME, turns, testHP, testDEF));
    charactersCopy.put(CharacterClass.ENGINEER, new Engineer(ENGINEER_NAME, turns, testHP, testDEF));
    charactersCopy.put(CharacterClass.WHITE_MAGE,new WhiteMage(WHITE_MAGE_NAME, turns, testHP, testDEF, testMP));
    charactersCopy.put(CharacterClass.ENEMY, new Enemy(ENEMY_NAME, testWeight, turns, testHP, testDEF, testATK ));


    charactersDiff = new EnumMap<>(CharacterClass.class);
    charactersDiff.put(CharacterClass.BLACK_MAGE, new BlackMage("Charlie", turns));
    charactersDiff.put(CharacterClass.KNIGHT, new Knight("Charlie", turns));
    charactersDiff.put(CharacterClass.THIEF, new Thief("Charlie", turns));
    charactersDiff.put(CharacterClass.ENGINEER, new Engineer("Charlie", turns));
    charactersDiff.put(CharacterClass.WHITE_MAGE,new WhiteMage("Charlie", turns));
    charactersDiff.put(CharacterClass.ENEMY, new Enemy("Jorgito", 3, turns, 1, 5, 6 ));

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
  void equipWeaponTest() {
    for (var charClass : CharacterClass.values()) {
      if (charClass != CharacterClass.ENEMY){
        var character = (AbsPlayerCharacter) characters.get(charClass);
        assertNull(character.getEquippedWeapon());
        character.equip(testWeapon);
        assertEquals(testWeapon, character.getEquippedWeapon());
        assertNotEquals(testWeapon, character);
      }
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
}

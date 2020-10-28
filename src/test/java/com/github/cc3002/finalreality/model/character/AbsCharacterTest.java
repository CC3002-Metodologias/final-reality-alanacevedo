package com.github.cc3002.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.Knight;
import com.github.alanacevedo.finalreality.model.weapon.AbstractWeapon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.alanacevedo.finalreality.model.weapon.Knife;
import com.github.alanacevedo.finalreality.model.weapon.Sword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author <M. Alan Acevedo Salazar>
 * @see ICharacter
 */
public abstract class AbsCharacterTest {

  protected BlockingQueue<ICharacter> turns;
  protected List<ICharacter> testCharacters;
  protected AbstractWeapon testWeapon;

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */


  @Test
  void waitTurnTest() {
    testCharacters = new ArrayList<>();
    Knight character = new Knight("Juan", turns, 3, 2);
    AbstractWeapon wpn = new Sword("espadita", 15, 10);
    character.equip(wpn);

    testCharacters.add(character);
    Assertions.assertTrue(turns.isEmpty());
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(800);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(500);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  


  protected void checkConstruction(final ICharacter expectedCharacter,
      final ICharacter testEqualCharacter,
      final ICharacter sameClassDifferentCharacter,
      final ICharacter differentClassCharacter) {
    assertEquals(expectedCharacter, expectedCharacter);
    assertEquals(expectedCharacter, testEqualCharacter);
    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());
  }

  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Knife("Test", 15, 10);
    testCharacters = new ArrayList<>();
  }
}

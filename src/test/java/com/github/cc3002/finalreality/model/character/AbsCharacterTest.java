package com.github.cc3002.finalreality.model.character;

import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;
import com.github.alanacevedo.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

  static final String BLACK_MAGE_NAME = "Vivi";
  static final String KNIGHT_NAME = "Adelbert";
  static final String WHITE_MAGE_NAME = "Eiko";
  static final String ENGINEER_NAME = "Cid";
  static final String THIEF_NAME = "Zidane";

  int testHP = 100;
  int testDEF = 10;
  int testMP = 50;
  int testWeight = 5;
  int testATK = 20;

  BlackMage testBlackMage;
  Knight testKnight;
  Thief testThief;
  Engineer testEngineer;
  WhiteMage testWhiteMage;
  Enemy testEnemy;

  Axe testAxe;
  Sword testSword;
  Bow testBow;
  Staff testStaff;
  Knife testKnife;

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

  void generateCharactersAndWeapons() {
    testBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, testHP, testDEF, testMP);
    testKnight = new Knight(KNIGHT_NAME, turns, testHP, testDEF);
    testThief = new Thief(THIEF_NAME, turns, testHP, testDEF);
    testEngineer = new Engineer(ENGINEER_NAME, turns, testHP, testDEF);
    testWhiteMage = new WhiteMage(WHITE_MAGE_NAME, turns, testHP, testDEF, testMP);
    testEnemy = new Enemy("skelet", 20, turns, 40, 10, 10);

    testAxe = new Axe("Hacha", testATK, testWeight);
    testSword = new Sword("Espada", testATK, testWeight);
    testKnife = new Knife("Cuchillo", testATK, testWeight);
    testBow = new Bow("Arco", testATK, testWeight);
    testStaff = new Staff("Bastón", testATK, testWeight, 10);
  }

  // Test de ataque básico
  @Test
  void characterAttackTest() {
    generateCharactersAndWeapons();
    Sword testSword = new Sword("Espada", 20, testWeight);
    Axe testAxe = new Axe("Hachita", 110, testWeight);
    Knight testKnight = new Knight(KNIGHT_NAME, turns, testHP, testDEF);
    BlackMage testBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, 100, 10, testMP);

    // Si un personaje no tiene un arma equipada, no debería hacer daño al intentar atacar.
    assertNull(testKnight.getEquippedWeapon());
    assertEquals(testBlackMage.getHP(), 100); // BlackMage HP = 100, DEF= 10
    testKnight.attack(testBlackMage);
    assertEquals(testBlackMage.getHP(), 100); // Como no tenía arma, no debería hacer daño.
    testKnight.equip(testSword); // Sword damage = 20
    testKnight.attack(testBlackMage);
    assertEquals(testBlackMage.getHP(), 90); // Debería ser 100 - max(0, 20-10) = 90
    testKnight.equip(testAxe); // Axe damage = 110
    testKnight.attack(testBlackMage);
    // El daño recibido es max(0, 110-10) = 100. Al recibir el ataque su vida efectiva es 90-100 = 10, pero debería
    // quedar en 0 y actualizar su estado a muerto. (Overkill).
    assertEquals(testBlackMage.getHP(), 0);
    assertFalse(testBlackMage.isAlive());
    testKnight.attack(testBlackMage);
    assertEquals(testBlackMage.getHP(), 0); // Atacar un personaje muerto no debería hacer nada.
    assertFalse(testBlackMage.isAlive());

    testKnight.receiveDamage(200); //killed
    assertEquals(testEngineer.getHP(), 100);
    testKnight.attack(testEngineer); // Is dead, shouldn't be able to attack.
    assertEquals(testEngineer.getHP(), 100);

    testBlackMage = new BlackMage(BLACK_MAGE_NAME, turns, 100, 10, testMP);
    Enemy testWeakEnemy = new Enemy("skeletSMOL", 20, turns, 40, 10, 20);
    Enemy testStrongEnemy = new Enemy("skeletBEEG", 20, turns, 40, 10, 110);

    // Los siguientes test siguen la misma lógica pero con enemigos atacando.
    assertEquals(testBlackMage.getHP(), 100);
    testWeakEnemy.attack(testBlackMage);
    assertEquals(testBlackMage.getHP(), 90);
    testStrongEnemy.attack(testBlackMage);
    assertEquals(testBlackMage.getHP(), 0);
    assertFalse(testBlackMage.isAlive());
    testStrongEnemy.attack(testBlackMage);
    assertEquals(testBlackMage.getHP(), 0);
    assertFalse(testBlackMage.isAlive());

    testWeakEnemy.receiveDamage(100); // killed
    testWeakEnemy.attack(testEngineer); // Is dead, shouldn't be able to attack.
    assertEquals(testEngineer.getHP(), 100);

  }
}

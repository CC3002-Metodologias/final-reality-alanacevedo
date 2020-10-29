package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.alanacevedo.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int MAGICDAMAGE = 10;
  private static final int WEIGHT = 10;

  private AbstractWeapon testAxe;
  private AbstractWeapon testStaff;
  private AbstractWeapon testSword;
  private AbstractWeapon testBow;
  private AbstractWeapon testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    testStaff = new Staff(STAFF_NAME, DAMAGE, WEIGHT, MAGICDAMAGE);
    testSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
    testBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, WEIGHT);
  }

  @Test
  void constructorTest() {
    Axe expectedAxe = new Axe(AXE_NAME, DAMAGE, WEIGHT);
    Axe diffWeight = new Axe(AXE_NAME, DAMAGE, 999);
    Axe diffDamage = new Axe(AXE_NAME, 1, WEIGHT);
    Staff expectedStaff = new Staff(STAFF_NAME, DAMAGE, WEIGHT, MAGICDAMAGE);
    Staff diffMagicDamage = new Staff(STAFF_NAME, DAMAGE, WEIGHT, 1);
    Sword expectedSword = new Sword(SWORD_NAME, DAMAGE, WEIGHT);
    Bow expectedBow = new Bow(BOW_NAME, DAMAGE, WEIGHT);
    Knife expectedKnife = new Knife (KNIFE_NAME, DAMAGE, WEIGHT);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
    assertNotEquals(testKnife, testBow);
    assertNotEquals(expectedAxe, diffDamage);
    assertNotEquals(expectedStaff, diffMagicDamage);
    assertNotEquals(diffWeight, expectedAxe);
    assertEquals(testKnife.getMagicDamage(), 0);
  }

   
}
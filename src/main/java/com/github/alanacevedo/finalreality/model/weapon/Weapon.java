package com.github.alanacevedo.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <M. Alan Acevedo Salazar>
 */
public class Weapon {

  private final String name;
  private final int ATK;
  private final int weight;
  private final WeaponType type;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   *
   * @see WeaponType
   * @param name
   *    name of the weapon
   * @param damage
   *    damage this weapon deals
   * @param weight
   *    weight of the weapon
   * @param  type
   *    type of the weapon.
   */
  public Weapon(final String name, final int damage, final int weight,
      final WeaponType type) {
    this.name = name;
    this.ATK = damage;
    this.weight = weight;
    this.type = type;
  }

  /**
   * @return
   *    weapon name
   */
  public String getName() {
    return name;
  }

  /**
   * @return
   *    weapon damage
   */
  public int getDamage() {
    return ATK;
  }

  /**
   * @return
   *    weapon weight
   */
  public int getWeight() {
    return weight;
  }

  /**
   * @return
   *    weapon type
   */
  public WeaponType getType() {
    return type;
  }

  /**
   *
   * @param o Other Object
   *  @return
   *     true if 'o' has the same characteristics as this weapon.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Weapon)) {
      return false;
    }
    final Weapon weapon = (Weapon) o;
    return getDamage() == weapon.getDamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName()) &&
        getType() == weapon.getType();
  }

  /**
   * Función utilizada junto a equals.
   * @return Hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType());
  }
}

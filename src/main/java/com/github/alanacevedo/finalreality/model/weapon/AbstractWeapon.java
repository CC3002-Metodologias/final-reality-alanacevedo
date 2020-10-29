package com.github.alanacevedo.finalreality.model.weapon;

import com.github.alanacevedo.finalreality.model.character.AbstractCharacter;
import com.github.alanacevedo.finalreality.model.character.player.AbsPlayerCharacter;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <M. Alan Acevedo Salazar>
 */
public abstract class AbstractWeapon implements IWeapon {

  private final String name;
  private final int ATK;
  private final int weight;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   * @param name
   *    name of the weapon
   * @param damage
   *    damage this weapon deals
   * @param weight
   *    weight of the weapon
   **/
  public AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.ATK = damage;
    this.weight = weight;
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
    if (!(o instanceof AbstractWeapon)) {
      return false;
    }
    final AbstractWeapon weapon = (AbstractWeapon) o;
    return getDamage() == weapon.getDamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName());
  }

  /**
   * Función utilizada junto a equals.
   * @return Hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight());
  }

  // Por defecto las armas no se puede equipar para ninguna clase.
  // En caso de que si se pueda, se hará override al método correspondiente.

  @Override
  public void equipToBlackMage(BlackMage blackMage) {
    ;
  }

  @Override
  public void equipToEngineer(Engineer engineer) {
    ;
  }

  @Override
  public void equipToKnight(Knight knight) {
    ;
  }

  @Override
  public void equipToThief(Thief thief) {
    ;
  }

  @Override
  public void equipToWhiteMage(WhiteMage whiteMage) {
    ;
  }
  @Override
  public int getMagicDamage(){
    return 0;
  }
}

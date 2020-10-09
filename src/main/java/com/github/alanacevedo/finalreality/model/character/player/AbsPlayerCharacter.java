package com.github.alanacevedo.finalreality.model.character.player;

import com.github.alanacevedo.finalreality.model.character.AbstractCharacter;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.github.alanacevedo.finalreality.model.weapon.Weapon;
import com.github.alanacevedo.finalreality.model.weapon.WeaponType;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author M. Alan Acevedo Salazar
 */
public abstract class AbsPlayerCharacter extends AbstractCharacter implements IPlayableCharacter {

  protected Weapon equippedWeapon = null;
  protected final CharacterClass characterClass;
  protected WeaponType[] allowedWeapons;

  /**
   * Creates a new abstract party character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   * @param HP
   *     this character's hit points (health points)
   * @param DEF
   *     this character's defense points
   */

  public AbsPlayerCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                            final CharacterClass characterClass, int HP, int DEF) {
    super(turnsQueue, name);
    this.characterClass = characterClass;
    this.HP = HP;
    this.DEF = DEF;
  }


  /**
   * Equips this character with a weapon.
   * @param weapon
   *      The weapon that is equipped.
   */
  public void equip(Weapon weapon) {
    this.equippedWeapon = weapon;
  }

  /**
   * Gets this character equipped weapon.
   * @return
   *      Returns this character's equipped Weapon object.
   */
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * Gets this character class
   * @return
   *      Returns object from CharacterClass enum.
   */
  public CharacterClass getCharacterClass() {
    return characterClass;
  }

  @Override
  public void waitTurn(){
    super.waitTurn();
    scheduledExecutor
            .schedule(this::addToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
  }

}

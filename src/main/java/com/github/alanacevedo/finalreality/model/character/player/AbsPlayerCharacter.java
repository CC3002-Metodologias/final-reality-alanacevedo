package com.github.alanacevedo.finalreality.model.character.player;

import com.github.alanacevedo.finalreality.model.character.AbstractCharacter;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;

import java.beans.PropertyChangeEvent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.github.alanacevedo.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author M. Alan Acevedo Salazar
 */
public abstract class AbsPlayerCharacter extends AbstractCharacter implements IPlayableCharacter {

  protected AbstractWeapon equippedWeapon = null;

  /**
   * Creates a new abstract party character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param HP
   *     this character's hit points (health points)
   * @param DEF
   *     this character's defense points
   */

  protected AbsPlayerCharacter(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                            int HP, int DEF) {
    super(turnsQueue, name);
    this.HP = HP;
    this.maxHP = HP;
    this.DEF = DEF;
  }



  @Override
  public AbstractWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  
  @Override
  public void waitTurn(){
    super.waitTurn();
    if (this.getEquippedWeapon() == null) {
      scheduledExecutor.schedule(this::notifyAddToQueue, 1/10, TimeUnit.SECONDS);
    } else {
      scheduledExecutor.schedule(this::notifyAddToQueue, equippedWeapon.getWeight() / 10, TimeUnit.SECONDS);
    }
  }

  /**
   * changes value of equippedWeapon attribute
   * @param weapon new value
   */
  public void setEquippedWeapon(AbstractWeapon weapon) {
    this.equippedWeapon = weapon;
  }

  @Override
  public void attack(ICharacter character) {
    if (this.isAlive()) {
      character.attackedByPlayableCharacter(this);
    }
  }

  @Override
  public void receiveDamage(int ammount) {
    this.HP -= ammount;
    if (this.HP <= 0) {
      this.HP = 0;
      this.aliveStatus = false;
      if (deathHandler!=null) {
        deathHandler.propertyChange(new PropertyChangeEvent(this, "playerCharacterDeath", null, null));
      }
    }
  }

  public void takeTurn() {
    turnStartHandler.propertyChange(new PropertyChangeEvent(this, "playerCharTurnStart", null, null));

  }

}

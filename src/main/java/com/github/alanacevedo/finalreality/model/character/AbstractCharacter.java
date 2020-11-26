package com.github.alanacevedo.finalreality.model.character;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;
import com.github.alanacevedo.finalreality.model.weapon.AbstractWeapon;
import org.jetbrains.annotations.NotNull;

import static java.lang.Integer.max;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author <M. Alan Acevedo Salazar>
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected ScheduledExecutorService scheduledExecutor;
  protected final String name;
  protected int HP;
  protected int maxHP;
  protected int DEF;
  protected boolean aliveStatus;

  /**
   * Initializes a character.
   *
   * @param turnsQueue
   *    the queue with the characters waiting for their turn
   *
   * @param name
   *    Character's name.
   */

  protected AbstractCharacter(@NotNull BlockingQueue<ICharacter> turnsQueue,
      @NotNull String name) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.aliveStatus = true;
  }

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();

  }
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getHP(){
    return HP;
  }

  @Override
  public int getDEF(){
    return DEF;
  }

  @Override
  public boolean isAlive() {
    return this.aliveStatus;
  }

  public int getMaxHP() {
    return this.maxHP;
  }

  @Override
  public void receiveDamage(int ammount) {
    this.HP -= ammount;
    if (this.HP <= 0) {
      this.HP = 0;
      this.aliveStatus = false;
    }
  }

  @Override
  public void heal(int ammount) {
    this.HP += ammount;
    if (this.HP > this.maxHP) {
      this.HP = this.maxHP;
    }
  }

  @Override
  public void attackedByPlayableCharacter(IPlayableCharacter character) {
    AbstractWeapon characterWeapon = character.getEquippedWeapon();
    if (this.aliveStatus && characterWeapon != null) {
      int weaponDamage = characterWeapon.getDamage();
      int damageDone = max(0, weaponDamage - this.DEF);
      this.receiveDamage(damageDone);

      if (this.HP <= 0) {
        this.aliveStatus = false;
        this.HP = 0;
      }
    }
  }

  @Override
  public void attackedByEnemy(Enemy enemy) {
    if (this.aliveStatus) {
      int enemyDamage = enemy.getATK();
      int damageDone = max(0, enemyDamage - this.DEF);
      this.receiveDamage(damageDone);

      if (this.HP <= 0) {
        this.aliveStatus = false;
        this.HP = 0;
      }
    }
  }
}

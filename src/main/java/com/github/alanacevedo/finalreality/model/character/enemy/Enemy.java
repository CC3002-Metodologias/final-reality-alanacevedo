package com.github.alanacevedo.finalreality.model.character.enemy;

import java.beans.PropertyChangeEvent;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import com.github.alanacevedo.finalreality.model.character.AbstractCharacter;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz
 * @author <M. Alan Acevedo Salazar>
 *
 */
public class Enemy extends AbstractCharacter {

  private final int weight;
  protected int ATK;
  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   *
   * @param name
   *    This enemy's name
   * @param turnsQueue
   *    the queue with the characters waiting for their turn
   * @param weight
   *    This enemy's weight
   * @param HP
   *    This enemy's hit points (health points)
   * @param DEF
   *    This enemy's defense
   * @param ATK
   *    This enemy's attack or damage stat.
   */
  public Enemy(@NotNull final String name, final int weight,
               @NotNull final BlockingQueue<ICharacter> turnsQueue, int HP, int DEF, int ATK) {
    super(turnsQueue, name);
    this.weight = weight;
    this.HP = HP;
    this.maxHP = HP;
    this.DEF = DEF;
    this.ATK = ATK;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Returns the damage of this enemy.
   */
  public int getATK(){
    return ATK;
  }

  /**
   * Función utilizada junto a equals.
   * @return Hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getWeight(),getName(), getDEF(), getHP(),
            getATK());
  }

  /**
   *
   * @param o Other Object
   *  @return
   *     true if 'o' has the same characteristics as this enemy.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Enemy)) {
      return false;
    }
    final Enemy enemy = (Enemy) o;
    return getWeight() == enemy.getWeight()
            && getATK() == enemy.getATK()
            && getHP() == enemy.getHP()
            && getName().equals(enemy.getName())
            && getDEF() == enemy.getDEF();
  }

  @Override
  public void waitTurn(){
    super.waitTurn();
    scheduledExecutor
            .schedule(this::notifyAddToQueue, this.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public void attack(ICharacter character) {
    if (this.isAlive()) {
      character.attackedByEnemy(this);
    }
  }

  @Override
  public void receiveDamage(int ammount) {
    this.HP -= ammount;
    if (this.HP <= 0) {
      this.HP = 0;
      this.aliveStatus = false;
      listeners.firePropertyChange(new PropertyChangeEvent(this, "enemyDeath", null, null));
    }
  }

  @Override
  public void takeTurn() {
    listeners.firePropertyChange(new PropertyChangeEvent(this, "enemyTurnStart", null, null));
  }

}

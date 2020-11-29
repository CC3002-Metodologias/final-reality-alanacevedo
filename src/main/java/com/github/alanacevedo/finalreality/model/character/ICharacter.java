package com.github.alanacevedo.finalreality.model.character;


import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;

import java.beans.PropertyChangeListener;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author M. Alan Acevedo Salazar
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns character's health points.
   */
  int getHP();

  /**
   *
   * Returns character's max health points.
   */
  int getMaxHP();

  /**
   * Returns character's defense points.
   */
  int getDEF();


  /**
   * Intenta atacar a un enemigo (no tiene efecto si el objetivo está muerto).
   * @param character personaje a atacar.
   */
  void attack(ICharacter character);

  /**
   * Actualiza los valores de vida de este personaje al ser atacado por un PC.
   * @param playerCharacter quien atacó a este personaje.
   */
  void attackedByPlayableCharacter(IPlayableCharacter playerCharacter);

  /**
   * Actualiza los valores de vida de este personaje al ser atacado por un Enemy
   * @param enemy quien atacó a este personaje.
   */
  void attackedByEnemy(Enemy enemy);

  /**
   * Retorna un bool que representa si este personaje está vivo o muerto.
   * @return true si el personaje esta vivo.
   */
  boolean isAlive();

  /**
   * @param o Other Object (Character ideally)
   * @return true if 'o' has the same characteristics as this character.
   */
  boolean equals(Object o);

  /**
   * Función utilizada junto a equals.
   * @return Hashcode
   */
  int hashCode();

  /**
   * Substracts health points to this character.
   * @param ammount health substracted
   */
  void receiveDamage(int ammount);

  /**
   * Adds health points to this character.
   * @param ammount health added
   */
  void heal(int ammount);

  /**
   * Notifies the game controller that this character is ready to be added to the turns queue.
   */
  void addToQueue();

  /**
   * Notifies the game controller that this character is ready to take its turn.
   */
  void takeTurn();

  /**
   * Sets this character's AddToQueueHandler
   * @param listener handler to be set
   */
  void setAddToQueueHandler(PropertyChangeListener listener);

  /**
   * Sets this character's DeathHandler
   * @param listener handler to be set
   */
  void setDeathHandler(PropertyChangeListener listener);

  /**
   * Sets this character's TurnStartHandler
   * @param listener handler to be set
   */
  void setTurnStartHandler(PropertyChangeListener listener);
}

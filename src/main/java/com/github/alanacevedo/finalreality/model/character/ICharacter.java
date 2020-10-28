package com.github.alanacevedo.finalreality.model.character;


import com.github.alanacevedo.finalreality.model.character.player.AbsPlayerCharacter;
import com.github.alanacevedo.finalreality.model.weapon.*;

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
   * Returns character's health points
   */
  int getCharacterHP();

  /**
   * Returns character's defense points
   */
  int getCharacterDEF();


  /**
   * Intenta atacar a un enemigo (no tiene efecto si el objetivo está muerto).
   * @param character personaje a atacar.
   */
  void attack(AbstractCharacter character);

  /**
   * Actualiza los valores de vida de este personaje al ser atacado por un PC.
   * @param playerCharacter quien atacó a este personaje.
   */
  void attackedByPlayableCharacter(AbsPlayerCharacter playerCharacter);

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


}

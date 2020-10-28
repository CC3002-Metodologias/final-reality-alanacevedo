package com.github.alanacevedo.finalreality.model.character;


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


}

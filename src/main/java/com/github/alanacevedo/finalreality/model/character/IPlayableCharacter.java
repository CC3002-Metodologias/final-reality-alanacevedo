package com.github.alanacevedo.finalreality.model.character;
import com.github.alanacevedo.finalreality.model.weapon.*;

/**
 * This represents a character from the player's party.
 */
public interface IPlayableCharacter {

    /**
     * Gets this character equipped weapon.
     * @return
     *      Returns this character's equipped Weapon object.
     */
    AbstractWeapon getEquippedWeapon();


    /**
     * Equipa un arma a este personaje. Considera las restricciones de clases de los personajes.
     * @param weapon el arma a equipar
     */
    void equip(AbstractWeapon weapon);

    /**
     * changes value of equippedWeapon attribute
     * @param weapon new value
     */
    void setEquippedWeapon(AbstractWeapon weapon);
}

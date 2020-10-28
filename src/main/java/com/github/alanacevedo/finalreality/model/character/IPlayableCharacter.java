package com.github.alanacevedo.finalreality.model.character;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.weapon.*;

/**
 * This represents a character from the player's party.
 */
public interface IPlayableCharacter {
    void setEquippedWeapon(AbstractWeapon weapon);

    /**
     * Gets this character equipped weapon.
     * @return
     *      Returns this character's equipped Weapon object.
     */
    AbstractWeapon getEquippedWeapon();

    /**
     * Gets this character class
     * @return
     *      Returns object from CharacterClass enum.
     */
    CharacterClass getCharacterClass();

    /**
     * Equipa un arma a este personaje.
     * @param weapon el arma a equipar
     */
    void equip(AbstractWeapon weapon);
}

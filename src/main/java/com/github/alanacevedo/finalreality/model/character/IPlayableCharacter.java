package com.github.alanacevedo.finalreality.model.character;
import com.github.alanacevedo.finalreality.model.character.player.CharacterClass;
import com.github.alanacevedo.finalreality.model.weapon.Weapon;

/**
 * This represents a character from the player's party.
 */
public interface IPlayableCharacter {
    /**
     * Equips this character with a weapon.
     * @param weapon
     *      The weapon that is equipped.
     */
    void equip(Weapon weapon);

    /**
     * Gets this character equipped weapon.
     * @return
     *      Returns this character's equipped Weapon object.
     */
    Weapon getEquippedWeapon();

    /**
     * Gets this character class
     * @return
     *      Returns object from CharacterClass enum.
     */
    CharacterClass getCharacterClass();
}

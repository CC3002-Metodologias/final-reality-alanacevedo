package com.github.alanacevedo.finalreality.model.weapon;

import com.github.alanacevedo.finalreality.model.character.player.AbsPlayerCharacter;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;

public interface IWeapon {

    String getName();
    int getWeight();
    int getDamage();

    /**
     * Returns this weapon's Magic Damage. By default returns 0.
     * @return Weapon's magic damage.
     */
    int getMagicDamage();


    // Los métodos equipToClass equipan esta arma al personaje de clase Class.

    /**
     * Intenta equipar esta arma a un Black Mage
     * @param blackMage personaje al que se intentará equipar esta arma.
     */
    void equipToBlackMage(BlackMage blackMage);

    /**
     * Intenta equipar esta arma a un Engineer
     * @param engineer personaje al que se intentará equipar esta arma.
     */
    void equipToEngineer(Engineer engineer);

    /**
     * Intenta equipar esta arma a un Knight
     * @param knight personaje al que se intentará equipar esta arma.
     */
    void equipToKnight(Knight knight);

    /**
     * Intenta equipar esta arma a un Thief
     * @param thief personaje al que se intentará equipar esta arma.
     */
    void equipToThief(Thief thief);

    /**
     * Intenta equipar esta arma a un White Mage
     * @param whiteMage personaje al que se intentará equipar esta arma.
     */
    void equipToWhiteMage(WhiteMage whiteMage);


}

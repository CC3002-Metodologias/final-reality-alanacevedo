package com.github.alanacevedo.finalreality.model.magic.BlackMagic;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.IMageCharacter;
import com.github.alanacevedo.finalreality.model.magic.IMagicSpell;

public class Thunder implements IMagicSpell {
    IMageCharacter mage;
    int mpCost = 15;

    public Thunder(IMageCharacter mageCharacter) {
        mage = mageCharacter;
    }

    @Override
    public void cast(ICharacter character) {
        if (mage.isAlive() && character.isAlive() && mage.getEquippedWeapon()!=null && mage.getMP()>=mpCost) {
            int magicDamage = mage.getEquippedWeapon().getMagicDamage();
            character.receiveDamage(magicDamage);
            mage.spendMP(mpCost);
            //30% chance thunder
        }
    }
}
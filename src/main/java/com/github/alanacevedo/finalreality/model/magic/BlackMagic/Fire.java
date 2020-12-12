package com.github.alanacevedo.finalreality.model.magic.BlackMagic;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.IMageCharacter;
import com.github.alanacevedo.finalreality.model.magic.IMagicSpell;

public class Fire implements IMagicSpell {
    IMageCharacter mage;
    int mpCost = 15;
    final String name = "Fire";

    public Fire(IMageCharacter mageCharacter) {
        mage = mageCharacter;
    }

    @Override
    public void cast(ICharacter character) {
        if (mage.isAlive() && character.isAlive() && mage.getEquippedWeapon()!=null && mage.getMP()>=mpCost) {
            int magicDamage = mage.getEquippedWeapon().getMagicDamage();
            character.receiveDamage(magicDamage);
            mage.spendMP(mpCost);
            //20% chance burn
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

package com.github.alanacevedo.finalreality.model.magic.WhiteMagic;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.IMageCharacter;
import com.github.alanacevedo.finalreality.model.magic.IMagicSpell;

public class Cure implements IMagicSpell {
    IMageCharacter mage;
    int mpCost = 15;
    final String name = "Cure";
    public Cure(IMageCharacter character) {
        mage = character;
    }

    @Override
    public void cast(ICharacter character) {
        if (character.isAlive() && mage.isAlive() && mage.getMP()>=mpCost) {
            int healAmmount = (int) (character.getMaxHP() * 0.3);
            character.heal(healAmmount);
            mage.spendMP(mpCost);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

package com.github.alanacevedo.finalreality.model.magic.WhiteMagic;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.IMageCharacter;
import com.github.alanacevedo.finalreality.model.magic.IMagicSpell;

public class Poison implements IMagicSpell {
    IMageCharacter mage;
    int mpCost = 40;

    public Poison(IMageCharacter character) {
        mage = character;
    }

    @Override
    public void cast(ICharacter character) {

    }
}

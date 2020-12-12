package com.github.alanacevedo.finalreality.model.magic.WhiteMagic;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.player.IMageCharacter;
import com.github.alanacevedo.finalreality.model.magic.IMagicSpell;

public class Paralisis implements IMagicSpell {
    IMageCharacter mage;
    int mpCost = 25;
    final String name = "Paralisis";

    public Paralisis(IMageCharacter character) {
        mage = character;
    }

    @Override
    public void cast(ICharacter character) {

    }

    @Override
    public String getName() {
        return name;
    }
}
package com.github.alanacevedo.finalreality.model.magic;

import com.github.alanacevedo.finalreality.model.character.ICharacter;

public class NullSpell implements  IMagicSpell {

    @Override
    public void cast(ICharacter character) {
    }

    @Override
    public String getName() {
        return "";
    }
}

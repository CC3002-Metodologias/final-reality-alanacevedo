package com.github.alanacevedo.finalreality.model.magic;

import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.model.weapon.IWeapon;

import java.util.Arrays;

public class SpellBook {
    private final int maxSize = Settings.spellBookSize;
    private IMagicSpell[] spellList;
    private int currentSize;

    public SpellBook(IMagicSpell... args) {
        spellList = new IMagicSpell[maxSize];
        Arrays.fill(spellList, new NullSpell());
        currentSize = 0;
        for (IMagicSpell spell : args) {
            this.addSpell(spell);
        }
    }

    public void addSpell(IMagicSpell spell) {
        if (currentSize < maxSize) {
            for (int i=0; i<maxSize; i++) {
                if (spellList[i].getName().equals("")) {
                    spellList[i] = spell;
                    currentSize++;
                    break;
                }
            }
        }
    }

    public IMagicSpell getSpell(int slot) {
        return spellList[slot];
    }

    public IMagicSpell getSpell(String spellName) {
        for (IMagicSpell spell: spellList) {
            if (spell.getName().equals(spellName)) {
                return spell;
            }
        }
        return new NullSpell();
    }
}

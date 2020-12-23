package com.github.alanacevedo.finalreality.controller.phase.command.magic.magicSelectionPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.magic.MagicTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.model.character.player.IMageCharacter;
import com.github.alanacevedo.finalreality.model.magic.IMagicSpell;

/**
 * Selects one of the mage's spells.
 */
public class SelectSpellCommand extends AbstractCommand implements ICommand {
    int slot;
    IMagicSpell spell;

    public SelectSpellCommand(IPhase phase, int slot) {
        super(phase);
        this.slot = slot;
        IMageCharacter mage = (IMageCharacter) parentPhase.getController().getCurrentChar();
        spell = mage.getSpellBook().getSpell(slot);
    }

    @Override
    public String getName() {
        return spell.getName();
    }

    @Override
    public void doAction() {
        parentPhase.changePhase(new MagicTargetSelectionPhase(parentPhase.getController(), spell));
    }
}

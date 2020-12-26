package com.github.alanacevedo.finalreality.controller.phase.command.actionSelectPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.magic.MagicSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

/**
 * Changes the game phase to MagicSelectionPhase
 * Can only be used if the current character is a mage
 */
public class MagicCommand extends AbstractCommand {
    public MagicCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "Magic";
    }

    @Override
    public void doAction() {
        if (parentPhase.getController().getCurrentChar().isMage()) {
            parentPhase.changePhase(new MagicSelectionPhase(parentPhase.getController()));
        }
    }
}

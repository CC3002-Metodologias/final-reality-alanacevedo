package com.github.alanacevedo.finalreality.controller.phase.command.actionSelectPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.magic.MagicSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class MagicCommand extends AbstractCommand implements ICommand {
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

package com.github.alanacevedo.finalreality.controller.phase.command.attack.attackTargetSelectionPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.ActionSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

/**
 * Returns to the previous phase
 */
public class GoBackCommand extends AbstractCommand {
    public GoBackCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "Back";
    }

    @Override
    public void doAction() {
        parentPhase.changePhase(new ActionSelectionPhase(parentPhase.getController()));
    }
}

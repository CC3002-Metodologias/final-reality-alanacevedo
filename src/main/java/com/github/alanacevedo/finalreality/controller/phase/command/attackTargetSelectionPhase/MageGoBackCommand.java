package com.github.alanacevedo.finalreality.controller.phase.command.attackTargetSelectionPhase;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.controller.phase.mageVariants.MageActionSelectionPhase;

public class MageGoBackCommand extends GoBackCommand implements ICommand {
    public MageGoBackCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public void doAction() {
        parentPhase.changePhase(new MageActionSelectionPhase(parentPhase.getController()));
    }
}

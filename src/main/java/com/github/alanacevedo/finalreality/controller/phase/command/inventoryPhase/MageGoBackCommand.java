package com.github.alanacevedo.finalreality.controller.phase.command.inventoryPhase;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.mageVariants.MageActionSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class MageGoBackCommand extends GoBackCommand implements ICommand {
    public MageGoBackCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public void doAction() {
        parentPhase.changePhase(new MageActionSelectionPhase(parentPhase.getController()));
    }
}

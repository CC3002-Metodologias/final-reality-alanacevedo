package com.github.alanacevedo.finalreality.controller.phase.command.magicSelectionPhase;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.mageVariants.MageActionSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class GoBackCommand extends AbstractCommand implements ICommand {
    public GoBackCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "Back";
    }

    @Override
    public void doAction() {
        parentPhase.changePhase(new MageActionSelectionPhase(parentPhase.getController()));
    }
}

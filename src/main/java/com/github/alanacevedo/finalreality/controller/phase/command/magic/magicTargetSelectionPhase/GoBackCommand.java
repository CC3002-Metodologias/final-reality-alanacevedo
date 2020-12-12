package com.github.alanacevedo.finalreality.controller.phase.command.magic.magicTargetSelectionPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.magic.MagicSelectionPhase;
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
        parentPhase.changePhase(new MagicSelectionPhase(parentPhase.getController()));
    }
}

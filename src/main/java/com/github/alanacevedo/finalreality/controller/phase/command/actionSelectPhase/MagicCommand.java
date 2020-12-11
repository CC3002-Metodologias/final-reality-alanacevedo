package com.github.alanacevedo.finalreality.controller.phase.command.actionSelectPhase;

import com.github.alanacevedo.finalreality.controller.phase.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.MagicSelectionPhase;
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
        parentPhase.changePhase(new MagicSelectionPhase(parentPhase.getController()));
    }
}

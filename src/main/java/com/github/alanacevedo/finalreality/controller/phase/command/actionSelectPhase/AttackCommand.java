package com.github.alanacevedo.finalreality.controller.phase.command.actionSelectPhase;

import com.github.alanacevedo.finalreality.controller.phase.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class AttackCommand extends AbstractCommand implements ICommand {
    public AttackCommand(IPhase phase) {
        super(phase);

    }
    public String getName() {
        return "Attack";
    }

    @Override
    public void doAction() {
        parentPhase.changePhase(new AttackTargetSelectionPhase(parentPhase.getController()));
    }
}

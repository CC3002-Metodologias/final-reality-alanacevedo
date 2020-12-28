package com.github.alanacevedo.finalreality.controller.phase.command.actionSelectPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.attack.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

/**
 * Changes the game phase to AttackTargetSelectionPhase
 * Can only be used if the current character has a weapon equipped.
 */
public class AttackCommand extends AbstractCommand {
    public AttackCommand(IPhase phase) {
        super(phase);

    }
    public String getName() {
        return "Attack";
    }

    @Override
    public void doAction() {
        if (!parentPhase.getController().getCurrentChar().getEquippedWeapon().isNull()) {
        parentPhase.changePhase(new AttackTargetSelectionPhase(parentPhase.getController()));
        }
    }

}

package com.github.alanacevedo.finalreality.controller.phase.command.attack.attackTargetSelectionPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

/**
 * Attacks the corresponding enemy
 */
public class AttackEnemySlotCommand extends AbstractCommand {
    private final int slot;

    public AttackEnemySlotCommand(IPhase phase, int slot) {
        super(phase);
        this.slot = slot;
    }

    @Override
    public String getName() {
        return "Attack Enemy " + slot;
    }

    @Override
    public void doAction() {
        parentPhase.getController().attackEnemySlot(slot);
    }
}

package com.github.alanacevedo.finalreality.controller.phase.command.magic.magicTargetSelectionPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.magic.MagicTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.model.magic.IMagicSpell;

public class CastOnEnemySlotCommand extends AbstractCommand implements ICommand {
    private final int slot;

    public CastOnEnemySlotCommand(IPhase phase, int slot) {
        super(phase);
        this.slot = slot;
    }

    @Override
    public String getName() {
        return "Cast on Enemy " + slot;
    }

    @Override
    public void doAction() {
        IMagicSpell spell = ((MagicTargetSelectionPhase) parentPhase).getSpell();
        parentPhase.getController().castSpellOnEnemySlot(spell, slot);
    }
}

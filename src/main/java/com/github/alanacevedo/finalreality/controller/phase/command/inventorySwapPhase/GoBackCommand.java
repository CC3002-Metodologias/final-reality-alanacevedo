package com.github.alanacevedo.finalreality.controller.phase.command.inventorySwapPhase;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class GoBackCommand extends AbstractCommand implements ICommand {
    public GoBackCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "back";
    }

    @Override
    public void doAction() {
        parentPhase.changePhase(new InventoryPhase(parentPhase.getController()));
    }
}

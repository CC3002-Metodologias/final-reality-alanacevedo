package com.github.alanacevedo.finalreality.controller.phase.command.inventorySwapPhase;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.InventorySwapPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class ScrollUpCommand extends AbstractCommand implements ICommand {

    public ScrollUpCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "scrollUp";
    }

    @Override
    public void doAction() {
        ((InventorySwapPhase) parentPhase).scrollUp();
    }
}

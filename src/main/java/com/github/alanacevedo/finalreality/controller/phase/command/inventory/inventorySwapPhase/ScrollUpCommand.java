package com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventorySwapPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventorySwapPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

/**
 * Scrolls the visible inventory slots upwards
 */
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

package com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventoryPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

/**
 * Scrolls the visible inventory slots upwards
 */
public class ScrollUpCommand extends AbstractCommand  {

    public ScrollUpCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "scrollUp";
    }

    @Override
    public void doAction() {
        ((InventoryPhase) parentPhase).scrollUp();
        ((InventoryPhase) parentPhase).setHighLightedSlot(-1);
    }
}

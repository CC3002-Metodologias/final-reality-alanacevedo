package com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventoryPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class ScrollDownCommand extends AbstractCommand implements ICommand {

    public ScrollDownCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "scrollDown";
    }

    @Override
    public void doAction() {
        ((InventoryPhase) parentPhase).scrollDown();
        ((InventoryPhase) parentPhase).setHighLightedSlot(-1);
    }
}
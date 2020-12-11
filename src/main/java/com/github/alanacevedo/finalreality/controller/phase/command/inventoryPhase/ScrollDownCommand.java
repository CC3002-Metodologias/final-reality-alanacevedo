package com.github.alanacevedo.finalreality.controller.phase.command.inventoryPhase;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class ScrollDownCommand extends AbstractCommand implements ICommand {

    public ScrollDownCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "scrollUp";
    }

    @Override
    public void doAction() {
        ((InventoryPhase) parentPhase).scrollDown();
    }
}
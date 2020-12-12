package com.github.alanacevedo.finalreality.controller.phase.command.inventoryPhase;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.InventorySwapPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class SwapCommand extends AbstractCommand implements ICommand {
    public SwapCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "Swap";
    }

    @Override
    public void doAction() {
        parentPhase.changePhase(new InventorySwapPhase(parentPhase.getController(),
                ((InventoryPhase) parentPhase).getHighlightedSlot()));
    }
}

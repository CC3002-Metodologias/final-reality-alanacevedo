package com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventorySwapPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventorySwapPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class ConfirmSwapCommand extends AbstractCommand implements ICommand {
    public ConfirmSwapCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "Confirm";
    }

    @Override
    public void doAction() {
        int slot1 = ((InventorySwapPhase) parentPhase).getFirstSlot();
        int slot2 = ((InventorySwapPhase) parentPhase).getHighlightedSlot();
        if (slot2 != -1) {
            parentPhase.getController().swapInventorySlots(slot1, slot2);
            ((InventorySwapPhase) parentPhase).getGoBackCommand().doAction();
        }

    }
}

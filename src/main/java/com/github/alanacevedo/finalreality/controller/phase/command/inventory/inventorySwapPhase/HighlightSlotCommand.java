package com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventorySwapPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventorySwapPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

/**
 * Selects the second weapon to be swapped.
 */
public class HighlightSlotCommand extends AbstractCommand {
    int currentSlot;
    String name;

    public HighlightSlotCommand(InventorySwapPhase phase, int slot) {
        super(phase);
        currentSlot = slot;
        name = parentPhase.getController().getPlayer().getWeaponFromInventory(currentSlot).getName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doAction() {
        ((InventorySwapPhase) parentPhase).setHighlightedSlot(currentSlot);
    }


    public void updateName() {
        name = parentPhase.getController().getPlayer().getWeaponFromInventory(currentSlot).getName();
    }

    public void scrollUp() {
        currentSlot--;
    }

    public void scrollDown() {
        currentSlot++;
    }
}

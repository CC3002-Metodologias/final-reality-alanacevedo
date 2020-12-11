package com.github.alanacevedo.finalreality.controller.phase.command.inventoryPhase;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.model.player.Inventory;

public class HighlightSlotCommand extends AbstractCommand implements ICommand {
    int currentSlot;
    String name;

    public HighlightSlotCommand(InventoryPhase phase, int slot) {
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
        ((InventoryPhase) parentPhase).setHighLightedSlot(currentSlot);
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

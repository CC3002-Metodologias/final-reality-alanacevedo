package com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventoryPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.model.weapon.IWeapon;

/**
 * Selects a weapon to be equiped or swaped
 */
public class HighlightSlotCommand extends AbstractCommand {
    int currentSlot;
    String name;

    public HighlightSlotCommand(InventoryPhase phase, int slot) {
        super(phase);
        currentSlot = slot;
        IWeapon wpn = parentPhase.getController().getPlayer().getWeaponFromInventory(currentSlot);
        if (wpn != null) {
            name = wpn.getName();
        } else {
            name = "";
        }
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

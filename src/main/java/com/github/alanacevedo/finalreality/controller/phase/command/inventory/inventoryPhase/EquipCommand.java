package com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventoryPhase;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;

public class EquipCommand extends AbstractCommand implements ICommand {

    public EquipCommand(IPhase phase) {
        super(phase);
    }


    @Override
    public String getName() {
        return "Equip";
    }

    @Override
    public void doAction() {
        int slot = ((InventoryPhase) parentPhase).getHighlightedSlot();
        if (slot != -1) {
            parentPhase.getController().equipWeaponToCurrentCharacter(slot);
        }
    }

}

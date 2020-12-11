package com.github.alanacevedo.finalreality.controller.phase.command.inventoryPhase;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.InventoryPhase;
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
        parentPhase.getController().equipWeaponToCurrentCharacter(((InventoryPhase) parentPhase).getHighLightedSlot());
    }

}

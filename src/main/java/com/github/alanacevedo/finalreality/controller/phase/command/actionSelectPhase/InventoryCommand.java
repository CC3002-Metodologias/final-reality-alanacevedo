package com.github.alanacevedo.finalreality.controller.phase.command.actionSelectPhase;

import com.github.alanacevedo.finalreality.controller.phase.command.AbstractCommand;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;

/**
 * Changes the game phase to InventoryPhase
 */
public class InventoryCommand extends AbstractCommand implements ICommand {
    public InventoryCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "Inventory";
    }

    @Override
    public void doAction() {
        parentPhase.changePhase(new InventoryPhase(parentPhase.getController()));
    }
}

package com.github.alanacevedo.finalreality.controller.phase.mageVariants;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.IPhase;
import com.github.alanacevedo.finalreality.controller.phase.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.inventoryPhase.*;
import org.jetbrains.annotations.NotNull;

public class MageInventoryPhase extends InventoryPhase implements IPhase{
    public MageInventoryPhase(@NotNull GameController controller) {
        super(controller);
        goBackCommand = new MageGoBackCommand(this);
    }
}

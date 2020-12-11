package com.github.alanacevedo.finalreality.controller.phase.mageVariants;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.ActionSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.actionSelectPhase.*;
import org.jetbrains.annotations.NotNull;

public class MageActionSelectionPhase extends ActionSelectionPhase {


    public MageActionSelectionPhase(@NotNull GameController controller) {
        super(controller);
        magicCommand = new MagicCommand(this);
    }
}

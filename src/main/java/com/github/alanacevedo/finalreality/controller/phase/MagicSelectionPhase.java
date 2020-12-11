package com.github.alanacevedo.finalreality.controller.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import org.jetbrains.annotations.NotNull;
import com.github.alanacevedo.finalreality.controller.phase.command.magicSelectionPhase.*;

// Select Skill, then select enemy to use skill on
public class MagicSelectionPhase extends AbstractPhase implements IPhase {

    GoBackCommand goBackCommand;

    public MagicSelectionPhase(@NotNull GameController controller) {
        super(controller);
        goBackCommand = new GoBackCommand(this);
    }

    public GoBackCommand getGoBackCommand() {
        return goBackCommand;
    }
}

package com.github.alanacevedo.finalreality.controller.phase.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import org.jetbrains.annotations.NotNull;

public class WaitingPhase extends AbstractPhase implements IPhase{

    public WaitingPhase(@NotNull GameController controller) {
        super(controller);
        name = "Waiting";
    }

    public String getName() {
        return this.name;
    }
}

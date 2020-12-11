package com.github.alanacevedo.finalreality.controller.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPhase {

    public GameController controller;

    public AbstractPhase(final @NotNull GameController controller) {
        this.controller = controller;
    }

    public void changePhase(IPhase phase) {
        controller.setPhase(phase);
    }

    public GameController getController() {
        return controller;
    }

}

package com.github.alanacevedo.finalreality.controller.phase.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPhase {
    protected String name;
    protected AbstractPhaseScene phaseScene;

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

    public AbstractPhaseScene getPhaseScene() {
        return this.phaseScene;
    }

}

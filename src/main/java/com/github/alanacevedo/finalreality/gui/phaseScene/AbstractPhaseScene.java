package com.github.alanacevedo.finalreality.gui.phaseScene;

import javafx.scene.Group;
import javafx.scene.Scene;

/**
 * Abstract class representing a phase graphic scene.
 */
public abstract class AbstractPhaseScene {
    /**
     * Manages varying scene elements for this phase.
     */
    public abstract void handleTimer();

    /**
     * Returns the node containing elements specific to this phase.
     */
    public abstract Group getRoot();
}

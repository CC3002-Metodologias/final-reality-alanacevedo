package com.github.alanacevedo.finalreality.controller.phase.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;

/**
 * Interface that represents those classes corresponding to a game phase.
 */
public interface IPhase {
    /**
     * Changes the associated controller's phase to the given phase.
     */
    void changePhase(IPhase phase);

    /**
     * Gets the phase's associated controller.
     */
    GameController getController();

    /**
     * Returns the javaFX groupNode containing specific graphic elements for this phase.
     */
    AbstractPhaseScene getPhaseScene();
}

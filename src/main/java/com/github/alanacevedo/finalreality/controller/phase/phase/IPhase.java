package com.github.alanacevedo.finalreality.controller.phase.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;

public interface IPhase {
    void changePhase(IPhase phase);
    GameController getController();
    String getName();
    AbstractPhaseScene getPhaseScene();
}

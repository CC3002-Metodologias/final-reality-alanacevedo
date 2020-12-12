package com.github.alanacevedo.finalreality.controller.phase.phase;

import com.github.alanacevedo.finalreality.controller.GameController;

public interface IPhase {
    void changePhase(IPhase phase);
    GameController getController();
}

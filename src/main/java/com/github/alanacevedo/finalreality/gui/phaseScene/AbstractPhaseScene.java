package com.github.alanacevedo.finalreality.gui.phaseScene;

import javafx.scene.Group;
import javafx.scene.Scene;

public abstract class AbstractPhaseScene {
    public abstract void handleTimer();
    public abstract Group getRoot();
}

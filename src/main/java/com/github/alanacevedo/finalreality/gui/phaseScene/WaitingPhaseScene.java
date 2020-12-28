package com.github.alanacevedo.finalreality.gui.phaseScene;

import com.github.alanacevedo.finalreality.controller.GameController;
import javafx.scene.Group;

/**
 * Graphic scene for WaitingPhase
 */
public class WaitingPhaseScene extends AbstractPhaseScene {
    private Group root;


    public WaitingPhaseScene(GameController controller) {
        root = new Group();
    }

    @Override
    public void handleTimer() {

    }

    @Override
    public Group getRoot() {
        return root;
    }

}

package com.github.alanacevedo.finalreality.gui.phaseScene;

import com.github.alanacevedo.finalreality.controller.GameController;
import javafx.scene.Group;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class WaitingPhaseScene extends AbstractPhaseScene {
    private GameController controller;
    private Group root;


    public WaitingPhaseScene(GameController controller) {
        this.controller = controller;
        root = new Group();


    }

    public void handleTimer() {

    }

    public Group getRoot() {
        return root;
    }

}

package com.github.alanacevedo.finalreality.gui.phaseScene;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class WaitingPhaseScene extends AbstractPhaseScene {
    private GameController controller;

    private Label phaseLabel = new Label();

    private Group root;


    public WaitingPhaseScene(GameController controller) {
        this.controller = controller;

        root = new Group();

        root.getChildren().add(phaseLabel);
        phaseLabel.setLayoutX(10);
        phaseLabel.setLayoutY(10);


    }

    public void handleTimer() {

        if (controller.getUiScene().getRoot() != root) {
            controller.getUiScene().setRoot(root);
        }

        phaseLabel.setText(controller.getPhase().getName() + "Phase");
    }

    public Group getRoot() {
        return root;
    }




}

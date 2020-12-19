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
    private Label queueSizeLabel = new Label();
    private Label characterNameLabel = new Label();

    private Group root;


    public WaitingPhaseScene(GameController controller) {
        this.controller = controller;

        root = new Group();

        root.getChildren().add(phaseLabel);
        phaseLabel.setLayoutX(10);
        phaseLabel.setLayoutY(10);

        root.getChildren().add(queueSizeLabel);
        queueSizeLabel.setLayoutX(10);
        queueSizeLabel.setLayoutY(30);

        root.getChildren().add(characterNameLabel);
        characterNameLabel.setLayoutX(10);
        characterNameLabel.setLayoutY(50);


    }

    public void handleTimer() {

        controller.getUiScene().setRoot(root);
        phaseLabel.setText(controller.getPhase().getName() + "Phase");
        queueSizeLabel.setText(String.valueOf(controller.getTurnsQueue().size()));
        IPlayableCharacter currentChar = controller.getCurrentChar();
        if (currentChar != null) {
            characterNameLabel.setText(currentChar.getName());
        } else {
            characterNameLabel.setText("");
        }
    }

    public Group getRoot() {
        return root;
    }




}

package com.github.alanacevedo.finalreality.gui.phaseScene;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WaitingPhaseScene extends AbstractPhaseScene {
    private GameController controller;

    private Label phaseLabel = new Label();
    ImageView background;

    private Group root;


    public WaitingPhaseScene(GameController controller) {
        this.controller = controller;
        root = new Group();
        try {
            background = new javafx.scene.image.ImageView(new Image(new FileInputStream(Settings.resourcePath+"background.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        background.setFitWidth(Settings.width);
        background.setFitHeight(Settings.height);
        root.getChildren().add(background);

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

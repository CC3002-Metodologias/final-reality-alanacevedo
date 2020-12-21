package com.github.alanacevedo.finalreality.gui.phaseScene.commonElements;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CommonBattlePhaseElements {
    private final GameController controller;
    private final Group root = new Group();
    private final Label queueSizeLabel = new Label();
    private ImageView background;
    private final PartyStatus partyStatus;

    public CommonBattlePhaseElements(GameController controller) {
        this.controller = controller;

        try {
            background = new ImageView(new Image(new FileInputStream(Settings.resourcePath+"background.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        background.setFitWidth(Settings.width);
        background.setFitHeight(Settings.height);
        root.getChildren().add(background);

        partyStatus = new PartyStatus(controller);
        partyStatus.getNode().setLayoutX(620);
        partyStatus.getNode().setLayoutY(Settings.height-110);
        root.getChildren().add(partyStatus.getNode());

        Label phaseLabel = new Label(controller.getPhase().getName() + "Phase");
        Label characterNameLabel = new Label(controller.getCurrentChar().getName());

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
        queueSizeLabel.setText(String.valueOf(controller.getTurnsQueue().size()));
        partyStatus.handleTimer();
    }

    public Group getNode() {
        return root;
    }
}

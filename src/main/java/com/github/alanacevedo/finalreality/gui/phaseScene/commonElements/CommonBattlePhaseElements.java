package com.github.alanacevedo.finalreality.gui.phaseScene.commonElements;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.gui.nodes.CharacterSprite;
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
        

        CharacterSprite enemy1 = new CharacterSprite("Enemy.png");
        enemy1.getIdleAnimation().play();
        enemy1.getNode().setLayoutX(200);
        enemy1.getNode().setLayoutY(230);
        root.getChildren().add(enemy1.getNode());

        CharacterSprite enemy2 = new CharacterSprite("Enemy.png");
        enemy2.getIdleAnimation().play();
        enemy2.getNode().setLayoutX(150);
        enemy2.getNode().setLayoutY(280);
        root.getChildren().add(enemy2.getNode());

        CharacterSprite enemy3 = new CharacterSprite("Enemy.png");
        enemy3.getIdleAnimation().play();
        enemy3.getNode().setLayoutX(100);
        enemy3.getNode().setLayoutY(330);
        root.getChildren().add(enemy3.getNode());

        CharacterSprite blanche = new CharacterSprite("Blanche.png");
        blanche.getIdleAnimation().play();
        blanche.getNode().setLayoutX(Settings.width-200-64);
        blanche.getNode().setLayoutY(230);
        root.getChildren().add(blanche.getNode());

        CharacterSprite knight = new CharacterSprite("Knight.png");
        knight.getIdleAnimation().play();
        knight.getNode().setLayoutX(Settings.width - 150-64);
        knight.getNode().setLayoutY(280);
        root.getChildren().add(knight.getNode());

        CharacterSprite thief = new CharacterSprite("Thief.png");
        thief.getIdleAnimation().play();
        thief.getNode().setLayoutX(Settings.width - 100-64);
        thief.getNode().setLayoutY(330);
        root.getChildren().add(thief.getNode());
    }

    public void handleTimer() {
        queueSizeLabel.setText(String.valueOf(controller.getTurnsQueue().size()));
        partyStatus.handleTimer();
    }

    public Group getNode() {
        return root;
    }
}

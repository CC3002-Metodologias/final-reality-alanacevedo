package com.github.alanacevedo.finalreality.gui.phaseScene.attack;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.phase.attack.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommandButton;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommonBattlePhaseElements;
import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class AttackTargetSelectionPhaseScene extends AbstractPhaseScene {
    private final Group root = new Group();

    public AttackTargetSelectionPhaseScene(GameController controller) {
        //commonElements = new CommonBattlePhaseElements(controller);
        //root.getChildren().add(commonElements.getNode());

        StackPane backButton = (new CommandButton("Return")).getNode();
        backButton.setLayoutY(540);
        backButton.setLayoutX(325);
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((AttackTargetSelectionPhase) controller.getPhase()).getGoBackCommand().doAction();
            event.consume();
        });
        root.getChildren().add(backButton);


        Pane enemy0Pane = new Pane();
        enemy0Pane.setOpacity(0);
        enemy0Pane.setStyle("-fx-background-color: black");
        enemy0Pane.setMinHeight(64);
        enemy0Pane.setMinWidth(64);
        enemy0Pane.setLayoutX(200);
        enemy0Pane.setLayoutY(230);
        root.getChildren().add(enemy0Pane);
        enemy0Pane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((AttackTargetSelectionPhase) controller.getPhase()).getAttackCommand0().doAction();
            event.consume();
        });
        Pane enemy1Pane = new Pane();
        enemy1Pane.setOpacity(0);
        enemy1Pane.setStyle("-fx-background-color: black");
        enemy1Pane.setMinHeight(64);
        enemy1Pane.setMinWidth(64);
        enemy1Pane.setLayoutX(150);
        enemy1Pane.setLayoutY(280);
        root.getChildren().add(enemy1Pane);
        enemy1Pane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((AttackTargetSelectionPhase) controller.getPhase()).getAttackCommand1().doAction();
            event.consume();
        });

        Pane enemy2Pane = new Pane();
        enemy2Pane.setOpacity(0);
        enemy2Pane.setStyle("-fx-background-color: black");
        enemy2Pane.setMinHeight(64);
        enemy2Pane.setMinWidth(64);
        enemy2Pane.setLayoutX(100);
        enemy2Pane.setLayoutY(330);
        root.getChildren().add(enemy2Pane);
        enemy2Pane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((AttackTargetSelectionPhase) controller.getPhase()).getAttackCommand2().doAction();
            event.consume();
        });




        Font font = null;
        try {
            font = Font.loadFont(new FileInputStream(Settings.resourcePath+"manaspc.ttf"), 15);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Text centerText = new Text();
        root.getChildren().add(centerText);
        centerText.setText("Select Target");
        centerText.setFont(font);
        centerText.setLayoutX(310);
        centerText.setLayoutY(530);
        centerText.setFill(Color.WHITE);
        centerText.setTextAlignment(TextAlignment.CENTER);

    }

    @Override
    public void handleTimer() {

    }

    @Override
    public Group getRoot() {
        return root;
    }
}

package com.github.alanacevedo.finalreality.gui.phaseScene;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.phase.ActionSelectionPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommandButton;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommonBattlePhaseElements;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ActionSelectionPhaseScene extends AbstractPhaseScene {
    private final GameController controller;
    private final CommonBattlePhaseElements commonElements;
    private final Group root = new Group();

    public ActionSelectionPhaseScene(GameController controller){
        this.controller = controller;
        commonElements = new CommonBattlePhaseElements(controller);
        root.getChildren().add(commonElements.getNode());

        StackPane attackButton = (new CommandButton("Attack")).getNode();
        root.getChildren().add(attackButton);
        attackButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((ActionSelectionPhase) controller.getPhase()).getAttackCommand().doAction();
            event.consume();
        });

        StackPane inventoryButton = (new CommandButton("Inventory")).getNode();
        root.getChildren().add(inventoryButton);
        inventoryButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((ActionSelectionPhase) controller.getPhase()).getInventoryCommand().doAction();
            event.consume();
        });


        StackPane magicButton = (new CommandButton("Magic")).getNode();
        root.getChildren().add(magicButton);
        magicButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((ActionSelectionPhase) controller.getPhase()).getMagicCommand().doAction();
            event.consume();
        });

        Group commandGroup = new Group(attackButton, inventoryButton, magicButton);
        attackButton.setLayoutY(0);
        inventoryButton.setLayoutY(30);
        magicButton.setLayoutY(60);
        commandGroup.setLayoutX(30);
        commandGroup.setLayoutY(Settings.height-110);
        root.getChildren().add(commandGroup);

    }

    public void handleTimer() {

        if (controller.getUiScene().getRoot() != root) {
            controller.getUiScene().setRoot(root);
        }
        commonElements.handleTimer();
    }

    public Group getRoot() {
        return root;
    }




}
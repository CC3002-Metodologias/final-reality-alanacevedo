package com.github.alanacevedo.finalreality.gui.phaseScene;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.phase.ActionSelectionPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommandButton;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommonBattlePhaseElements;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ActionSelectionPhaseScene extends AbstractPhaseScene {
    private final GameController controller;
    private final Group root = new Group();
    private Text centerText = new Text();

    public ActionSelectionPhaseScene(GameController controller){
        this.controller = controller;
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

        Font font = null;
        try {
            font = Font.loadFont(new FileInputStream(Settings.resourcePath+"manaspc.ttf"), 15);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        root.getChildren().add(centerText);
        centerText.setText(controller.getCurrentChar().getName()+"'s Turn.\nSelect action.");
        centerText.setFont(font);
        centerText.setLayoutX(310);
        centerText.setLayoutY(530);
        centerText.setFill(Color.WHITE);
        centerText.setTextAlignment(TextAlignment.CENTER);
    }

    public void handleTimer() {

    }

    public Group getRoot() {
        return root;
    }




}
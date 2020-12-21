package com.github.alanacevedo.finalreality.gui.phaseScene;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.phase.ActionSelectionPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.ButtonFactory;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.PartyStatus;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ActionSelectionPhaseScene extends AbstractPhaseScene {
    private GameController controller;

    private Label phaseLabel = new Label();
    private Label queueSizeLabel = new Label();
    private Label characterNameLabel = new Label();
    private PartyStatus partyStatus;

    private final Group root = new Group();

    private ImageView testButton;
    private ImageView background;


    public ActionSelectionPhaseScene(GameController controller){
        this.controller = controller;

        try {
            background = new ImageView(new Image(new FileInputStream("src/main/resources/background.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        background.setFitWidth(Settings.width);
        background.setFitHeight(Settings.height);
        root.getChildren().add(background);

        root.getChildren().add(phaseLabel);
        phaseLabel.setLayoutX(10);
        phaseLabel.setLayoutY(10);

        root.getChildren().add(queueSizeLabel);
        queueSizeLabel.setLayoutX(10);
        queueSizeLabel.setLayoutY(30);

        root.getChildren().add(characterNameLabel);
        characterNameLabel.setLayoutX(10);
        characterNameLabel.setLayoutY(50);

        partyStatus = new PartyStatus(controller);
        partyStatus.getNode().setLayoutX(620);
        partyStatus.getNode().setLayoutY(Settings.height-110);
        root.getChildren().add(partyStatus.getNode());

        StackPane attackButton = ButtonFactory.generateButton("Attack");
        root.getChildren().add(attackButton);
        attackButton.setLayoutX(30);
        attackButton.setLayoutY(Settings.height-110);
        attackButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((ActionSelectionPhase) controller.getPhase()).getAttackCommand().doAction();
            event.consume();
        });

        StackPane inventoryButton = ButtonFactory.generateButton("Inventory");
        root.getChildren().add(inventoryButton);
        inventoryButton.setLayoutX(30);
        inventoryButton.setLayoutY(Settings.height-80);
        inventoryButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((ActionSelectionPhase) controller.getPhase()).getInventoryCommand().doAction();
            event.consume();
        });


        StackPane magicButton = ButtonFactory.generateButton("Magic");
        root.getChildren().add(magicButton);
        magicButton.setLayoutX(30);
        magicButton.setLayoutY(Settings.height-50);
        magicButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((ActionSelectionPhase) controller.getPhase()).getMagicCommand().doAction();
            event.consume();
        });

    }

    public void handleTimer() {

        if (controller.getUiScene().getRoot() != root) {
            controller.getUiScene().setRoot(root);
        }

        phaseLabel.setText(controller.getPhase().getName() + "Phase");
        queueSizeLabel.setText(String.valueOf(controller.getTurnsQueue().size()));
        IPlayableCharacter currentChar = controller.getCurrentChar();
        characterNameLabel.setText(currentChar.getName());


        partyStatus.handleTimer();
    }

    public Group getRoot() {
        return root;
    }




}
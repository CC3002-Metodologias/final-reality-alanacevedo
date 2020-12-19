package com.github.alanacevedo.finalreality.gui.phaseScene;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.phase.ActionSelectionPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.PartyStatus;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ActionSelectionPhaseScene extends AbstractPhaseScene {
    private GameController controller;

    private Label phaseLabel = new Label();
    private Label queueSizeLabel = new Label();
    private Label characterNameLabel = new Label();
    private PartyStatus partyStatus;
    private Button attackButton = new Button("Attack");
    private Button inventoryButton = new Button("Inventory");
    private Button magicButton = new Button("Magic");
    private Group root = new Group();


    public ActionSelectionPhaseScene(GameController controller) {
        this.controller = controller;


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
        partyStatus.getNode().setLayoutY(500);
        root.getChildren().add(partyStatus.getNode());

        root.getChildren().add(attackButton);
        attackButton.setLayoutX(200);
        attackButton.setLayoutY(200);
        attackButton.setOnAction(event -> ((ActionSelectionPhase) controller.getPhase()).getAttackCommand().doAction());

        root.getChildren().add(inventoryButton);
        inventoryButton.setLayoutX(100);
        inventoryButton.setLayoutY(200);
        inventoryButton.setOnAction(event -> ((ActionSelectionPhase) controller.getPhase()).getInventoryCommand().doAction());

        root.getChildren().add(magicButton);
        magicButton.setLayoutX(300);
        magicButton.setLayoutY(200);
        //magicButton.setOpacity(0.5);
        //magicButton.setPrefSize(30, 30);
        //ImageIcon myImage = new ImageIcon("images/myImage.jpg");
        //JButton button = new JButton(myImage);
        //magicButton.setBorder(null);
        magicButton.setOnAction(event -> ((ActionSelectionPhase) controller.getPhase()).getMagicCommand().doAction());


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
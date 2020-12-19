package com.github.alanacevedo.finalreality.gui.phaseScene.magic;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.phase.attack.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.magic.MagicSelectionPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.PartyStatus;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MagicSelectionPhaseScene extends AbstractPhaseScene {
    private GameController controller;
    private Group root = new Group();
    private PartyStatus partyStatus;
    private Label phaseLabel = new Label();
    private Label queueSizeLabel = new Label();
    private Label characterNameLabel = new Label();
    private Button backButton = new Button("Return");

    public MagicSelectionPhaseScene(GameController controller) {
        this.controller = controller;
        partyStatus = new PartyStatus(controller);
        partyStatus.getNode().setLayoutX(620);
        partyStatus.getNode().setLayoutY(500);
        root.getChildren().add(partyStatus.getNode());

        root.getChildren().add(phaseLabel);
        phaseLabel.setLayoutX(10);
        phaseLabel.setLayoutY(10);

        root.getChildren().add(queueSizeLabel);
        queueSizeLabel.setLayoutX(10);
        queueSizeLabel.setLayoutY(30);

        root.getChildren().add(characterNameLabel);
        characterNameLabel.setLayoutX(10);
        characterNameLabel.setLayoutY(50);

        root.getChildren().add(backButton);
        backButton.setLayoutY(300);
        backButton.setLayoutX(300);
        backButton.setOnAction(event -> ((MagicSelectionPhase) controller.getPhase()).getGoBackCommand().doAction());
    }

    @Override
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

    @Override
    public Group getRoot() {
        return root;
    }
}

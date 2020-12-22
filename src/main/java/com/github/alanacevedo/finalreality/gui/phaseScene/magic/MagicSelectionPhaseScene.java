package com.github.alanacevedo.finalreality.gui.phaseScene.magic;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.phase.attack.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.magic.MagicSelectionPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommandButton;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommonBattlePhaseElements;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.PartyStatus;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class MagicSelectionPhaseScene extends AbstractPhaseScene {
    private GameController controller;
    private Group root = new Group();
    private CommonBattlePhaseElements commonElements;

    public MagicSelectionPhaseScene(GameController controller) {
        this.controller = controller;
        commonElements = new CommonBattlePhaseElements(controller);
        root.getChildren().add(commonElements.getNode());

        StackPane backButton = (new CommandButton("Return")).getNode();
        backButton.setLayoutY(540);
        backButton.setLayoutX(325);
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((MagicSelectionPhase) controller.getPhase()).getGoBackCommand().doAction();
            event.consume();
        });
        root.getChildren().add(backButton);

        commonElements.displaceCenterTextPosition(-75, 0);
        commonElements.setCenterText("Magic is yet to be implemented.");
    }

    @Override
    public void handleTimer() {
        if (controller.getUiScene().getRoot() != root) {
            controller.getUiScene().setRoot(root);
        }
    }

    @Override
    public Group getRoot() {
        return root;
    }
}

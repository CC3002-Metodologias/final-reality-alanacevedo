package com.github.alanacevedo.finalreality.gui.phaseScene.attack;

import com.github.alanacevedo.finalreality.controller.GameController;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class AttackTargetSelectionPhaseScene extends AbstractPhaseScene {
    private GameController controller;
    private Group root = new Group();
    //private CommonBattlePhaseElements commonElements;

    public AttackTargetSelectionPhaseScene(GameController controller) {
        this.controller = controller;
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


/*
        Group enemy0Sprite = commonElements.getEnemy0SpriteNode();
        enemy0Sprite.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((AttackTargetSelectionPhase) controller.getPhase()).getAttackCommand0().doAction();
            event.consume();
        });

        Group enemy1Sprite = commonElements.getEnemy1SpriteNode();
        enemy1Sprite.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((AttackTargetSelectionPhase) controller.getPhase()).getAttackCommand1().doAction();
            event.consume();
        });

        Group enemy2Sprite = commonElements.getEnemy2SpriteNode();
        enemy2Sprite.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((AttackTargetSelectionPhase) controller.getPhase()).getAttackCommand2().doAction();
            event.consume();
        });

        commonElements.setCenterText("Select Target");
*/
    }

    @Override
    public void handleTimer() {

        //commonElements.handleTimer();
    }

    @Override
    public Group getRoot() {
        return root;
    }
}

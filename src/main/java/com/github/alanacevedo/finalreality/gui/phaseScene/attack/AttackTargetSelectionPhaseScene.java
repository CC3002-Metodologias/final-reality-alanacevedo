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
    private Button backButton = new Button("Return");
    private Label enemy0Label = new Label();
    private Label enemy1Label = new Label();
    private Label enemy2Label = new Label();
    private CommonBattlePhaseElements commonElements;

    public AttackTargetSelectionPhaseScene(GameController controller) {
        this.controller = controller;
        commonElements = new CommonBattlePhaseElements(controller);
        root.getChildren().add(commonElements.getNode());




        StackPane backButton = (new CommandButton("Return")).getNode();
        backButton.setLayoutY(540);
        backButton.setLayoutX(325);
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((AttackTargetSelectionPhase) controller.getPhase()).getGoBackCommand().doAction();
            event.consume();
        });
        root.getChildren().add(backButton);



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

    }

    @Override
    public void handleTimer() {
        if (controller.getUiScene().getRoot() != root) {
            controller.getUiScene().setRoot(root);
        }

        var enemy0 = controller.getEnemyGroup().getEnemy(0);
        var enemy1 = controller.getEnemyGroup().getEnemy(1);
        var enemy2 = controller.getEnemyGroup().getEnemy(2);

        enemy0Label.setText(enemy0.getName() + " HP: " + enemy0.getHP() + "/" + enemy0.getMaxHP());
        enemy1Label.setText(enemy1.getName() + " HP: " + enemy1.getHP() + "/" + enemy1.getMaxHP());
        enemy2Label.setText(enemy2.getName() + " HP: " + enemy2.getHP() + "/" + enemy2.getMaxHP());
        enemy0Label.setTextFill(Color.WHITE);
        enemy1Label.setTextFill(Color.WHITE);
        enemy2Label.setTextFill(Color.WHITE);

        commonElements.handleTimer();
    }

    @Override
    public Group getRoot() {
        return root;
    }
}

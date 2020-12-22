package com.github.alanacevedo.finalreality.gui.phaseScene.attack;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.phase.attack.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommonBattlePhaseElements;
import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class AttackTargetSelectionPhaseScene extends AbstractPhaseScene {
    private GameController controller;
    private Group root = new Group();
    private Button backButton = new Button("Return");
    private Label enemy0Label = new Label();
    private Label enemy1Label = new Label();
    private Label enemy2Label = new Label();
    private Enemy enemy0;
    private Enemy enemy1;
    private Enemy enemy2;
    private CommonBattlePhaseElements commonElements;

    public AttackTargetSelectionPhaseScene(GameController controller) {
        this.controller = controller;
        commonElements = new CommonBattlePhaseElements(controller);
        root.getChildren().add(commonElements.getNode());

        enemy0 = controller.getEnemyGroup().getEnemy(0);
        enemy1 = controller.getEnemyGroup().getEnemy(1);
        enemy2 = controller.getEnemyGroup().getEnemy(2);

        root.getChildren().add(backButton);
        backButton.setLayoutY(300);
        backButton.setLayoutX(300);
        backButton.setOnAction(event -> ((AttackTargetSelectionPhase) controller.getPhase()).getGoBackCommand().doAction());

        root.getChildren().addAll(enemy0Label, enemy1Label, enemy2Label);
        enemy0Label.setLayoutX(400);
        enemy0Label.setLayoutY(300);
        enemy1Label.setLayoutX(400);
        enemy1Label.setLayoutY(330);
        enemy2Label.setLayoutX(400);
        enemy2Label.setLayoutY(360);



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

    }

    @Override
    public void handleTimer() {
        if (controller.getUiScene().getRoot() != root) {
            controller.getUiScene().setRoot(root);
        }

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

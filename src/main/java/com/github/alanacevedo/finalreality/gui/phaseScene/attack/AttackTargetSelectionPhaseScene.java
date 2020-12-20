package com.github.alanacevedo.finalreality.gui.phaseScene.attack;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.phase.attack.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.PartyStatus;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AttackTargetSelectionPhaseScene extends AbstractPhaseScene {
    private GameController controller;
    private Group root = new Group();
    private PartyStatus partyStatus;
    private Label phaseLabel = new Label();
    private Label queueSizeLabel = new Label();
    private Label characterNameLabel = new Label();
    private Button backButton = new Button("Return");

    private Button enemy0Button = new Button("Attack slot 0");
    private Button enemy1Button = new Button("Attack slot 1");
    private Button enemy2Button = new Button("Attack slot 2");
    private Label enemy0Label = new Label();
    private Label enemy1Label = new Label();
    private Label enemy2Label = new Label();
    private Enemy enemy0;
    private Enemy enemy1;
    private Enemy enemy2;

    public AttackTargetSelectionPhaseScene(GameController controller) {
        this.controller = controller;

        enemy0 = controller.getEnemyGroup().getEnemy(0);
        enemy1 = controller.getEnemyGroup().getEnemy(1);
        enemy2 = controller.getEnemyGroup().getEnemy(2);

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
        backButton.setOnAction(event -> ((AttackTargetSelectionPhase) controller.getPhase()).getGoBackCommand().doAction());

        root.getChildren().addAll(enemy0Label, enemy1Label, enemy2Label);
        enemy0Label.setLayoutX(400);
        enemy0Label.setLayoutY(300);
        enemy1Label.setLayoutX(400);
        enemy1Label.setLayoutY(330);
        enemy2Label.setLayoutX(400);
        enemy2Label.setLayoutY(360);

        root.getChildren().addAll(enemy0Button, enemy1Button, enemy2Button);
        enemy0Button.setLayoutX(600);
        enemy0Button.setLayoutY(300);
        enemy1Button.setLayoutX(600);
        enemy1Button.setLayoutY(330);
        enemy2Button.setLayoutX(600);
        enemy2Button.setLayoutY(360);
        enemy0Button.setOnAction(event -> ((AttackTargetSelectionPhase) controller.getPhase()).getAttackCommand0().doAction());
        enemy1Button.setOnAction(event -> ((AttackTargetSelectionPhase) controller.getPhase()).getAttackCommand1().doAction());
        enemy2Button.setOnAction(event -> ((AttackTargetSelectionPhase) controller.getPhase()).getAttackCommand2().doAction());


    }

    @Override
    public void handleTimer() {
        if (controller.getUiScene().getRoot() != root) {
            controller.getUiScene().setRoot(root);
        }

        enemy0Label.setText(enemy0.getName() + " HP: " + enemy0.getHP() + "/" + enemy0.getMaxHP());
        enemy1Label.setText(enemy1.getName() + " HP: " + enemy1.getHP() + "/" + enemy1.getMaxHP());
        enemy2Label.setText(enemy2.getName() + " HP: " + enemy2.getHP() + "/" + enemy2.getMaxHP());

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

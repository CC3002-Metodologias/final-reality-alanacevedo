package com.github.alanacevedo.finalreality.gui.phaseScene.commonElements;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.gui.nodes.CharacterSprite;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Manages various graphic elements that are common for all the battle phases.
 */
public class CommonBattlePhaseElements {
    private final GameController controller;
    private final Group root = new Group();
    private final PartyStatus partyStatus;
    private final CharacterSprite enemy0;
    private final CharacterSprite enemy1;
    private final CharacterSprite enemy2;

    public CommonBattlePhaseElements(GameController controller) {
        this.controller = controller;
        root.getChildren().add(new Group(new Text("")));

        ImageView background = new ImageView();
        try {
            background = new ImageView(new Image(new FileInputStream(Settings.resourcePath+"background.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        background.setFitWidth(Settings.width);
        background.setFitHeight(Settings.height);
        root.getChildren().add(background);

        partyStatus = new PartyStatus(controller);
        partyStatus.getNode().setLayoutX(620);
        partyStatus.getNode().setLayoutY(Settings.height-110);
        root.getChildren().add(partyStatus.getNode());

        enemy0 = new CharacterSprite("Enemy.png");
        enemy0.getIdleAnimation().play();
        enemy0.getNode().setLayoutX(200);
        enemy0.getNode().setLayoutY(230);
        enemy0.enableHealthBar(controller.getEnemyGroup().getEnemy(0).getMaxHP());
        root.getChildren().add(enemy0.getNode());

        enemy1 = new CharacterSprite("Enemy.png");
        enemy1.getIdleAnimation().play();
        enemy1.getNode().setLayoutX(150);
        enemy1.getNode().setLayoutY(280);
        enemy1.enableHealthBar(controller.getEnemyGroup().getEnemy(1).getMaxHP());
        root.getChildren().add(enemy1.getNode());

        enemy2 = new CharacterSprite("Enemy.png");
        enemy2.getIdleAnimation().play();
        enemy2.getNode().setLayoutX(100);
        enemy2.getNode().setLayoutY(330);
        enemy2.enableHealthBar(controller.getEnemyGroup().getEnemy(2).getMaxHP());
        root.getChildren().add(enemy2.getNode());

        CharacterSprite blanche = new CharacterSprite("Blanche.png");
        blanche.getIdleAnimation().play();
        blanche.getNode().setLayoutX(Settings.width-200-64);
        blanche.getNode().setLayoutY(230);
        root.getChildren().add(blanche.getNode());

        CharacterSprite knight = new CharacterSprite("Knight.png");
        knight.getIdleAnimation().play();
        knight.getNode().setLayoutX(Settings.width - 150-64);
        knight.getNode().setLayoutY(280);
        root.getChildren().add(knight.getNode());

        CharacterSprite thief = new CharacterSprite("Thief.png");
        thief.getIdleAnimation().play();
        thief.getNode().setLayoutX(Settings.width - 100-64);
        thief.getNode().setLayoutY(330);
        root.getChildren().add(thief.getNode());

    }
    /**
     * Manages varying scene elements.
     */
    public void handleTimer() {
        partyStatus.handleTimer();
        enemy0.updateHealthBar(controller.getEnemyGroup().getEnemy(0).getHP());
        enemy1.updateHealthBar(controller.getEnemyGroup().getEnemy(1).getHP());
        enemy2.updateHealthBar(controller.getEnemyGroup().getEnemy(2).getHP());
    }

    /**
     * Returns the root node containing the rest of the graphic elements.
     */
    public Group getNode() {
        return root;
    }

}

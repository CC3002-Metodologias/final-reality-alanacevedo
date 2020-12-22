package com.github.alanacevedo.finalreality.gui.phaseScene.commonElements;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.gui.nodes.CharacterSprite;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CommonBattlePhaseElements {
    private final GameController controller;
    private final Group root = new Group();
    private ImageView background;
    private final PartyStatus partyStatus;
    private CharacterSprite enemy0;
    private CharacterSprite enemy1;
    private CharacterSprite enemy2;
    private Label centerText = new Label();

    public CommonBattlePhaseElements(GameController controller) {
        this.controller = controller;

        try {
            background = new ImageView(new Image(new FileInputStream(Settings.resourcePath+"background.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        background.setFitWidth(Settings.width);
        background.setFitHeight(Settings.height);
        root.getChildren().add(background);

        Font font = null;
        try {
            font = Font.loadFont(new FileInputStream(Settings.resourcePath+"manaspc.ttf"), 15);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        root.getChildren().add(centerText);
        centerText.setFont(font);
        centerText.setLayoutX(310);
        centerText.setLayoutY(510);
        centerText.setTextFill(Color.WHITE);
        centerText.setTextAlignment(TextAlignment.CENTER);

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

    public void handleTimer() {
        partyStatus.handleTimer();
        enemy0.updateHealthBar(controller.getEnemyGroup().getEnemy(0).getHP());
        enemy1.updateHealthBar(controller.getEnemyGroup().getEnemy(1).getHP());
        enemy2.updateHealthBar(controller.getEnemyGroup().getEnemy(2).getHP());
    }

    public void setCenterText(String newText) {
        centerText.setText(newText);
    }

    public void displaceCenterTextPosition(double x, double y){
        centerText.setLayoutX(centerText.getLayoutX() + x);
        centerText.setLayoutY(centerText.getLayoutY() + y);
    }

    public Group getNode() {
        return root;
    }

    public Group getEnemy0SpriteNode() {
        return enemy0.getNode();
    }

    public Group getEnemy1SpriteNode() {
        return enemy1.getNode();
    }

    public Group getEnemy2SpriteNode() {
        return enemy2.getNode();
    }
}

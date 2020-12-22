package com.github.alanacevedo.finalreality.gui.nodes;

import com.github.alanacevedo.finalreality.controller.Settings;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// Spritesheets should have each animation in a row. Each animation should have the same ammount of frames (columns).
public class CharacterSprite {
    private ImageView sprite;
    private Animation idleAnimation;
    private int height = 32;
    private int width = 32;
    private int animation_lenght = 4;
    private int columns = 10;

    public CharacterSprite(String fileName) {

        try {
             sprite = new ImageView(new Image(new FileInputStream(Settings.resourcePath+fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        sprite.setViewport(new Rectangle2D(0, 0, width, height));
        sprite.setFitHeight(height*2);
        sprite.setFitWidth(width*2);

        idleAnimation = new SpriteAnimation(
                sprite,
                Duration.millis(500),
                animation_lenght,columns,
                0, 0,
                width, height
        );
        idleAnimation.setCycleCount(Animation.INDEFINITE);
    }

    public Animation getIdleAnimation() {
        return idleAnimation;
    }

    public ImageView getNode() {
        return sprite;
    }



}

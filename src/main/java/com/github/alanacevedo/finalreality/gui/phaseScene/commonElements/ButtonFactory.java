package com.github.alanacevedo.finalreality.gui.phaseScene.commonElements;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ButtonFactory {

    public static StackPane generateButton(String text) {
        ImageView background = new ImageView();
        try {
            background = new ImageView(new Image(new FileInputStream("src/main/resources/command_background_1.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        background.setPreserveRatio(false);
        background.setFitWidth(100);
        background.setFitHeight(30);

        Text commandText = new Text(text);
        commandText.setFill(Color.WHITE);
        commandText.setTextAlignment(TextAlignment.CENTER);

        StackPane pane = new StackPane();
        pane.getChildren().addAll(background, commandText);

        return pane;
    }

}

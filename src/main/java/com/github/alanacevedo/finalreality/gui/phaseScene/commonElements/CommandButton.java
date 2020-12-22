package com.github.alanacevedo.finalreality.gui.phaseScene.commonElements;

import com.github.alanacevedo.finalreality.controller.Settings;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CommandButton {
    private final StackPane pane = new StackPane();
    private final Text commandText = new Text();

    public CommandButton(String text) {
        ImageView background = new ImageView();
        Font font = null;
        try {
            font = Font.loadFont(new FileInputStream(Settings.resourcePath+"manaspc.ttf"), 10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            background = new ImageView(new Image(new FileInputStream(Settings.resourcePath+"command_background_1.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        background.setPreserveRatio(false);
        background.setFitWidth(100);
        background.setFitHeight(30);

        commandText.setText(text);
        commandText.setFill(Color.WHITE);
        commandText.setTextAlignment(TextAlignment.CENTER);
        commandText.setFont(font);


        pane.getChildren().addAll(background, commandText);
    }

    public StackPane getNode() {
        return pane;
    }

    public void setText(String newText) {
        commandText.setText(newText);
    }

}

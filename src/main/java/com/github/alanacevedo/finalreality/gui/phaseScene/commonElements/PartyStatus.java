package com.github.alanacevedo.finalreality.gui.phaseScene.commonElements;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PartyStatus {
    Pane root = new Pane();
    Label char0Label;
    Label char1Label;
    Label char2Label;
    IPlayableCharacter char0;
    IPlayableCharacter char1;
    IPlayableCharacter char2;
    ImageView background;

    public PartyStatus(GameController controller) {
        root.setPrefSize(170, 90);

        Font font = null;
        try {
            font = Font.loadFont(new FileInputStream(Settings.resourcePath+"manaspc.ttf"), 11);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            background = new ImageView(new Image(new FileInputStream("src/main/resources/command_background_1.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        background.setFitWidth(170);
        background.setFitHeight(90);
        root.getChildren().add(background);
        root.setStyle("-fx-background-color: lightgrey;");

        char0 = controller.getPlayer().getCharacterFromParty(0);
        char1 = controller.getPlayer().getCharacterFromParty(1);
        char2 = controller.getPlayer().getCharacterFromParty(2);

        char0Label = new Label(char0.getName() + "   HP: "+ char0.getHP() +"/" + char1.getMaxHP());
        char1Label = new Label(char1.getName() + "   HP: "+ char1.getHP() +"/" + char1.getMaxHP());
        char2Label = new Label(char2.getName() + "   HP: "+ char2.getHP() +"/" + char2.getMaxHP());

        char0Label.setFont(font);
        char1Label.setFont(font);
        char2Label.setFont(font);

        char0Label.setTextFill(Color.WHITE);
        char1Label.setTextFill(Color.WHITE);
        char2Label.setTextFill(Color.WHITE);

        char0Label.setLayoutY(13);
        char0Label.setLayoutX(10);
        char1Label.setLayoutY(38);
        char1Label.setLayoutX(10);
        char2Label.setLayoutY(63);
        char2Label.setLayoutX(10);

        root.getChildren().addAll(char0Label, char1Label, char2Label);
    }

    public Node getNode() {
        return root;
    }

    public void handleTimer() {
        char0Label.setText(char0.getName() + "   HP: "+ char0.getHP() +"/" + char0.getMaxHP());
        char1Label.setText(char1.getName() + "   HP: "+ char1.getHP() +"/" + char1.getMaxHP());
        char2Label.setText(char2.getName() + "   HP: "+ char2.getHP() +"/" + char2.getMaxHP());
    }
}

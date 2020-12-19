package com.github.alanacevedo.finalreality.gui.phaseScene.commonElements;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PartyStatus {
    Pane root;
    Label char0Label;
    Label char1Label;
    Label char2Label;
    IPlayableCharacter char0;
    IPlayableCharacter char1;
    IPlayableCharacter char2;

    public PartyStatus(GameController controller) {
        root = new Pane();
        root.setPrefSize(150, 80);
        root.setStyle("-fx-background-color: lightgrey;");

        char0 = controller.getPlayer().getCharacterFromParty(0);
        char1 = controller.getPlayer().getCharacterFromParty(1);
        char2 = controller.getPlayer().getCharacterFromParty(2);

        char0Label = new Label(char0.getName() + "   HP: "+ char0.getHP() +"/" + char1.getMaxHP());
        char1Label = new Label(char1.getName() + "   HP: "+ char1.getHP() +"/" + char1.getMaxHP());
        char2Label = new Label(char2.getName() + "   HP: "+ char2.getHP() +"/" + char2.getMaxHP());

        char0Label.setLayoutY(10);
        char0Label.setLayoutX(10);
        char1Label.setLayoutY(30);
        char1Label.setLayoutX(10);
        char2Label.setLayoutY(50);
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

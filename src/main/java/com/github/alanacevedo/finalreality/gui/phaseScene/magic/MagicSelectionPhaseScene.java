package com.github.alanacevedo.finalreality.gui.phaseScene.magic;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.phase.attack.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.magic.MagicSelectionPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommandButton;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommonBattlePhaseElements;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.PartyStatus;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Graphic scene for MagicSelectionPhase
 */
public class MagicSelectionPhaseScene extends AbstractPhaseScene {
    private Group root = new Group();

    public MagicSelectionPhaseScene(GameController controller) {

        StackPane backButton = (new CommandButton("Return")).getNode();
        backButton.setLayoutY(540);
        backButton.setLayoutX(325);
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((MagicSelectionPhase) controller.getPhase()).getGoBackCommand().doAction();
            event.consume();
        });
        root.getChildren().add(backButton);


        Font font = null;
        try {
            font = Font.loadFont(new FileInputStream(Settings.resourcePath+"manaspc.ttf"), 15);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Text centerText = new Text();
        root.getChildren().add(centerText);
        centerText.setText("Magic is yet to be implemented");
        centerText.setFont(font);
        centerText.setLayoutX(240);
        centerText.setLayoutY(530);
        centerText.setFill(Color.WHITE);
        centerText.setTextAlignment(TextAlignment.CENTER);
    }

    @Override
    public void handleTimer() {
        
    }

    @Override
    public Group getRoot() {
        return root;
    }
}

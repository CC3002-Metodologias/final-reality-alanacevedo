package com.github.alanacevedo.finalreality.gui.phaseScene.inventory;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventorySwapPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommandButton;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommonBattlePhaseElements;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InventorySwapPhaseScene extends AbstractPhaseScene {
    private final GameController controller;
    private final Group root = new Group();
    private final CommandButton slot0Button = new CommandButton("");
    private final CommandButton slot1Button = new CommandButton("");
    private final CommandButton slot2Button = new CommandButton("");
    private final Group otherGroup = new Group();
    private final Text centerText = new Text();

    public InventorySwapPhaseScene(GameController controller) {
        this.controller = controller;

        StackPane slot0ButtonNode = slot0Button.getNode();
        StackPane slot1ButtonNode = slot1Button.getNode();
        StackPane slot2ButtonNode = slot2Button.getNode();


        slot0ButtonNode.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventorySwapPhase) controller.getPhase()).getHighlightCommand0().doAction();
            otherGroup.setDisable(false);
            otherGroup.setVisible(true);
            event.consume();
        });


        slot1ButtonNode.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventorySwapPhase) controller.getPhase()).getHighlightCommand1().doAction();
            otherGroup.setDisable(false);
            otherGroup.setVisible(true);
            event.consume();
        });

        slot2ButtonNode.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventorySwapPhase) controller.getPhase()).getHighlightCommand2().doAction();
            otherGroup.setDisable(false);
            otherGroup.setVisible(true);
            event.consume();
        });

        slot0ButtonNode.setLayoutY(0);
        slot1ButtonNode.setLayoutY(30);
        slot2ButtonNode.setLayoutY(60);

        Group slotButtons = new Group();
        slotButtons.getChildren().addAll(slot0ButtonNode, slot1ButtonNode, slot2ButtonNode);
        slotButtons.setLayoutY(Settings.height-110);
        slotButtons.setLayoutX(30);
        root.getChildren().add(slotButtons);

        StackPane scrollUpButton = (new CommandButton("Scroll Up")).getNode();
        scrollUpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventorySwapPhase) controller.getPhase()).getScrollUpCommand().doAction();
            event.consume();
        });

        StackPane scrollDownButton = (new CommandButton("Scroll Down")).getNode();
        scrollDownButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventorySwapPhase) controller.getPhase()).getScrollDownCommand().doAction();
            event.consume();
        });

        StackPane backButton = (new CommandButton("Return")).getNode();
        backButton.setLayoutY(30);
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventorySwapPhase) controller.getPhase()).getGoBackCommand().doAction();
            event.consume();
        });

        Group scrollGroup = new Group(scrollDownButton, scrollUpButton, backButton);
        scrollGroup.setLayoutX(135);
        scrollGroup.setLayoutY(Settings.height-110);
        scrollUpButton.setLayoutY(0);
        scrollDownButton.setLayoutY(60);
        root.getChildren().add(scrollGroup);

        StackPane swapButton = (new CommandButton("Confirm Swap")).getNode();
        swapButton.setLayoutY(30);
        swapButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventorySwapPhase) controller.getPhase()).getConfirmSwapCommand().doAction();
            event.consume();
        });


        otherGroup.getChildren().add(swapButton);
        otherGroup.setLayoutY(Settings.height-110);
        otherGroup.setLayoutX(240);
        otherGroup.setVisible(false);
        otherGroup.setDisable(true);

        root.getChildren().add(otherGroup);

        Font font = null;
        try {
            font = Font.loadFont(new FileInputStream(Settings.resourcePath+"manaspc.ttf"), 15);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        root.getChildren().add(centerText);
        centerText.setFont(font);
        centerText.setLayoutX(370);
        centerText.setLayoutY(520);
        centerText.setFill(Color.WHITE);
        centerText.setTextAlignment(TextAlignment.CENTER);

    }

    @Override
    public void handleTimer() {

        int topSlot = ((InventorySwapPhase) controller.getPhase()).getCurrentTopSlot();
        slot0Button.setText((topSlot+1) + ". " + controller.getPlayer().getWeaponFromInventory(topSlot).getName());
        slot1Button.setText((topSlot+2) + ". " + controller.getPlayer().getWeaponFromInventory(topSlot+1).getName());
        slot2Button.setText((topSlot+3) + ". " + controller.getPlayer().getWeaponFromInventory(topSlot+2).getName());

        var currentWeapon = controller.getCurrentChar().getEquippedWeapon();
        if (currentWeapon.isNull()) {
            centerText.setText("Equip a weapon");
        } else {
            centerText.setText("Currently Equipped:\n" +
                    currentWeapon.getName()+
                    "\nATK: "+ currentWeapon.getDamage()+
                    " WT: "+ currentWeapon.getWeight());

        }

    }

    @Override
    public Group getRoot() {
        return root;
    }
}

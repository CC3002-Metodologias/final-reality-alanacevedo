package com.github.alanacevedo.finalreality.gui.phaseScene.inventory;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommandButton;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommonBattlePhaseElements;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class InventoryPhaseScene extends AbstractPhaseScene {
    private GameController controller;
    private Group root = new Group();
    private Label highlightedSlotLabel = new Label();
    private Label equippedWeaponLabel = new Label();
    private Group slotButtons = new Group();
    private CommandButton slot0Button = new CommandButton("");
    private CommandButton slot1Button = new CommandButton("");
    private CommandButton slot2Button = new CommandButton("");
    private CommonBattlePhaseElements commonElements;
    private Group otherGroup = new Group();

    public InventoryPhaseScene(GameController controller) {
        this.controller = controller;

        commonElements = new CommonBattlePhaseElements(controller);
        root.getChildren().add(commonElements.getNode());

        root.getChildren().add(equippedWeaponLabel);
        equippedWeaponLabel.setLayoutX(10);
        equippedWeaponLabel.setLayoutY(70);



        StackPane slot0ButtonNode = slot0Button.getNode();
        StackPane slot1ButtonNode = slot1Button.getNode();
        StackPane slot2ButtonNode = slot2Button.getNode();


        slot0ButtonNode.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventoryPhase) controller.getPhase()).getHighlightCommand0().doAction();
            otherGroup.setDisable(false);
            otherGroup.setVisible(true);
            event.consume();
        });


        slot1ButtonNode.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventoryPhase) controller.getPhase()).getHighlightCommand1().doAction();
            otherGroup.setDisable(false);
            otherGroup.setVisible(true);
            event.consume();
        });

        slot2ButtonNode.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventoryPhase) controller.getPhase()).getHighlightCommand2().doAction();
            otherGroup.setDisable(false);
            otherGroup.setVisible(true);
            event.consume();
        });

        slot0ButtonNode.setLayoutY(0);
        slot1ButtonNode.setLayoutY(30);
        slot2ButtonNode.setLayoutY(60);

        slotButtons.getChildren().addAll(slot0ButtonNode, slot1ButtonNode, slot2ButtonNode);
        slotButtons.setLayoutY(Settings.height-110);
        slotButtons.setLayoutX(30);
        root.getChildren().add(slotButtons);

        root.getChildren().add(highlightedSlotLabel);
        highlightedSlotLabel.setLayoutY(250);
        highlightedSlotLabel.setLayoutX(100);

        StackPane scrollUpButton = (new CommandButton("Scroll Up")).getNode();
        scrollUpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventoryPhase) controller.getPhase()).getScrollUpCommand().doAction();
            event.consume();
        });

        StackPane scrollDownButton = (new CommandButton("Scroll Down")).getNode();
        scrollDownButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventoryPhase) controller.getPhase()).getScrollDownCommand().doAction();
            event.consume();
        });

        StackPane backButton = (new CommandButton("Return")).getNode();
        backButton.setLayoutY(30);
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventoryPhase) controller.getPhase()).getGoBackCommand().doAction();
            event.consume();
        });

        Group scrollGroup = new Group(scrollDownButton, scrollUpButton, backButton);
        scrollGroup.setLayoutX(135);
        scrollGroup.setLayoutY(Settings.height-110);
        scrollUpButton.setLayoutY(0);
        scrollDownButton.setLayoutY(60);
        root.getChildren().add(scrollGroup);

        StackPane equipButton = (new CommandButton("Equip Selected")).getNode();
        equipButton.setLayoutY(0);
        equipButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventoryPhase) controller.getPhase()).getEquipCommand().doAction();
            event.consume();
        });

        StackPane swapButton = (new CommandButton("Swap Selected")).getNode();
        swapButton.setLayoutY(30);
        swapButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ((InventoryPhase) controller.getPhase()).getSwapCommand().doAction();
            event.consume();
        });

        otherGroup.getChildren().addAll(equipButton, swapButton);
        otherGroup.setLayoutY(Settings.height-110);
        otherGroup.setLayoutX(240);
        otherGroup.setDisable(true);
        otherGroup.setVisible(false);

        root.getChildren().add(otherGroup);

    }

    @Override
    public void handleTimer() {
        if (controller.getUiScene().getRoot() != root) {
            controller.getUiScene().setRoot(root);
        }
        commonElements.handleTimer();

        int topSlot = ((InventoryPhase) controller.getPhase()).getCurrentTopSlot();
        slot0Button.setText((topSlot+1) + ". " + controller.getPlayer().getWeaponFromInventory(topSlot).getName());
        slot1Button.setText((topSlot+2) + ". " + controller.getPlayer().getWeaponFromInventory(topSlot+1).getName());
        slot2Button.setText((topSlot+3) + ". " + controller.getPlayer().getWeaponFromInventory(topSlot+2).getName());
        highlightedSlotLabel.setText("Highlighted slot: " + ((InventoryPhase) controller.getPhase()).getHighlightedSlot());

        equippedWeaponLabel.setText(controller.getCurrentChar().getEquippedWeapon().getName());

    }

    @Override
    public Group getRoot() {
        return root;
    }
}

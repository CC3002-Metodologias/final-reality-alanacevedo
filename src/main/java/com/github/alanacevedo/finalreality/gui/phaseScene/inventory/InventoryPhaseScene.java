package com.github.alanacevedo.finalreality.gui.phaseScene.inventory;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.phase.inventory.InventoryPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.PartyStatus;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class InventoryPhaseScene extends AbstractPhaseScene {
    private GameController controller;
    private Group root = new Group();
    private PartyStatus partyStatus;
    private Label phaseLabel = new Label();
    private Label queueSizeLabel = new Label();
    private Label characterNameLabel = new Label();
    private Label highlightedSlotLabel = new Label();
    private Label equippedWeaponLabel = new Label();
    private Button backButton = new Button("Return");
    private Button equipButton = new Button("Equip Selected");
    private Button scrollUpButton = new Button("Up");
    private Button scrollDownButton = new Button("Down");
    private ToggleGroup slotButtonsToggle = new ToggleGroup();
    private Group slotButtons = new Group();
    private ToggleButton slot0Button = new ToggleButton();
    private ToggleButton slot1Button = new ToggleButton();
    private ToggleButton slot2Button = new ToggleButton();

    public InventoryPhaseScene(GameController controller) {
        this.controller = controller;
        partyStatus = new PartyStatus(controller);
        partyStatus.getNode().setLayoutX(620);
        partyStatus.getNode().setLayoutY(500);
        root.getChildren().add(partyStatus.getNode());

        root.getChildren().add(phaseLabel);
        phaseLabel.setLayoutX(10);
        phaseLabel.setLayoutY(10);

        root.getChildren().add(queueSizeLabel);
        queueSizeLabel.setLayoutX(10);
        queueSizeLabel.setLayoutY(30);

        root.getChildren().add(characterNameLabel);
        characterNameLabel.setLayoutX(10);
        characterNameLabel.setLayoutY(50);

        root.getChildren().add(equippedWeaponLabel);
        equippedWeaponLabel.setLayoutX(10);
        equippedWeaponLabel.setLayoutY(70);

        root.getChildren().add(backButton);
        backButton.setLayoutY(300);
        backButton.setLayoutX(300);
        backButton.setOnAction(event -> ((InventoryPhase) controller.getPhase()).getGoBackCommand().doAction());

        slotButtonsToggle.getToggles().addAll(slot0Button, slot1Button, slot2Button);
        slotButtons.getChildren().addAll(slot0Button, slot1Button, slot2Button);
        root.getChildren().add(slotButtons);

        slot0Button.setOnAction(event -> ((InventoryPhase) controller.getPhase()).getHighlightCommand0().doAction());
        slot1Button.setOnAction(event -> ((InventoryPhase) controller.getPhase()).getHighlightCommand1().doAction());
        slot2Button.setOnAction(event -> ((InventoryPhase) controller.getPhase()).getHighlightCommand2().doAction());

        slot1Button.setLayoutY(30);
        slot2Button.setLayoutY(60);
        slotButtons.setLayoutY(300);
        slotButtons.setLayoutX(100);

        root.getChildren().add(highlightedSlotLabel);
        highlightedSlotLabel.setLayoutY(250);
        highlightedSlotLabel.setLayoutX(100);

        root.getChildren().add(equipButton);
        equipButton.setLayoutX(300);
        equipButton.setLayoutY(330);
        equipButton.setOnAction(event -> ((InventoryPhase) controller.getPhase()).getEquipCommand().doAction());

        root.getChildren().addAll(scrollDownButton, scrollUpButton);
        scrollUpButton.setLayoutX(300);
        scrollUpButton.setLayoutY(270);
        scrollUpButton.setOnAction(event -> ((InventoryPhase) controller.getPhase()).getScrollUpCommand().doAction());
        scrollDownButton.setLayoutX(300);
        scrollDownButton.setLayoutY(390);
        scrollDownButton.setOnAction(event -> ((InventoryPhase) controller.getPhase()).getScrollDownCommand().doAction());


    }

    @Override
    public void handleTimer() {
        if (controller.getUiScene().getRoot() != root) {
            controller.getUiScene().setRoot(root);
        }
        phaseLabel.setText(controller.getPhase().getName() + "Phase");
        queueSizeLabel.setText(String.valueOf(controller.getTurnsQueue().size()));
        IPlayableCharacter currentChar = controller.getCurrentChar();
        characterNameLabel.setText(currentChar.getName());

        int topSlot = ((InventoryPhase) controller.getPhase()).getCurrentTopSlot();
        slot0Button.setText(topSlot + ". " + controller.getPlayer().getWeaponFromInventory(topSlot).getName());
        slot1Button.setText((topSlot+1) + ". " + controller.getPlayer().getWeaponFromInventory(topSlot+1).getName());
        slot2Button.setText((topSlot+2) + ". " + controller.getPlayer().getWeaponFromInventory(topSlot+2).getName());
        highlightedSlotLabel.setText("Highlighted slot: " + ((InventoryPhase) controller.getPhase()).getHighlightedSlot());

        equippedWeaponLabel.setText(controller.getCurrentChar().getEquippedWeapon().getName());

        partyStatus.handleTimer();
    }

    @Override
    public Group getRoot() {
        return root;
    }
}

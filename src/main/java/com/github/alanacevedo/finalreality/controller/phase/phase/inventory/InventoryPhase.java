package com.github.alanacevedo.finalreality.controller.phase.phase.inventory;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventoryPhase.*;
import com.github.alanacevedo.finalreality.controller.phase.phase.AbstractPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.inventory.InventoryPhaseScene;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents the game phase in which the player selects a weapon from the inventory
 * then decides to equip it or to swap it with other weapon in the inventory
 */

public class InventoryPhase extends AbstractPhase {

    protected ICommand goBackCommand;
    protected HighlightSlotCommand highlightCommand0;
    protected HighlightSlotCommand highlightCommand1;
    protected HighlightSlotCommand highlightCommand2;
    protected EquipCommand equipCommand;
    protected ScrollDownCommand scrollDownCommand;
    protected ScrollUpCommand scrollUpCommand;
    protected SwapCommand swapCommand;
    private int currentTopSlot;
    private final int maxSlot = Settings.inventorySize - 3; // 3 because there will be 3 buttons
    int highLightedSlot = -1;

    public InventoryPhase(@NotNull GameController controller) {
        super(controller);

        goBackCommand = new GoBackCommand(this);
        highlightCommand0 = new HighlightSlotCommand(this, 0);
        highlightCommand1 = new HighlightSlotCommand(this, 1);
        highlightCommand2 = new HighlightSlotCommand(this, 2);
        equipCommand = new EquipCommand(this);
        scrollDownCommand = new ScrollDownCommand(this);
        scrollUpCommand = new ScrollUpCommand(this);
        swapCommand = new SwapCommand(this);
        currentTopSlot = 0;
        phaseScene = new InventoryPhaseScene(controller);
    }

    /**
     * Moves the visible slots upwards
     */
    public void scrollUp() {
        if (currentTopSlot > 0) {
            highlightCommand0.scrollUp();
            highlightCommand1.scrollUp();
            highlightCommand2.scrollUp();
            currentTopSlot--;
        }
    }

    /**
     * Moves the visible slots downwards
     */
    public void scrollDown() {
        if (currentTopSlot < maxSlot) {
            highlightCommand0.scrollDown();
            highlightCommand1.scrollDown();
            highlightCommand2.scrollDown();
            currentTopSlot++;
        }
    }

    /**
     * returns the corresponding command
     */
    public ICommand getGoBackCommand() {
        return goBackCommand;
    }

    /**
     * Sets the currently selected slot.
     */
    public void setHighLightedSlot(int slot) {
        highLightedSlot = slot;
    }

    /**
     * Returns the currently selected slot. -1 if none is selected.
     */
    public int getHighlightedSlot() {
        return highLightedSlot;
    }

    /**
     * returns the corresponding command
     */
    public HighlightSlotCommand getHighlightCommand0() {
        return highlightCommand0;
    }

    /**
     * returns the corresponding command
     */
    public HighlightSlotCommand getHighlightCommand1() {
        return highlightCommand1;
    }

    /**
     * returns the corresponding command
     */
    public HighlightSlotCommand getHighlightCommand2() {
        return highlightCommand2;
    }

    /**
     * returns the corresponding command
     */
    public EquipCommand getEquipCommand() {
        return equipCommand;
    }

    /**
     * returns the corresponding command
     */
    public ScrollDownCommand getScrollDownCommand() {
        return scrollDownCommand;
    }

    /**
     * returns the corresponding command
     */
    public ScrollUpCommand getScrollUpCommand() {
        return scrollUpCommand;
    }

    /**
     * returns the corresponding command
     */
    public SwapCommand getSwapCommand() {
        return swapCommand;
    }

    /**
     * Returns the topmost visible inventory slot.
     */
    public int getCurrentTopSlot() {
        return currentTopSlot;
    }

}

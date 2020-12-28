package com.github.alanacevedo.finalreality.controller.phase.phase.inventory;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventorySwapPhase.*;
import com.github.alanacevedo.finalreality.controller.phase.phase.AbstractPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.inventory.InventorySwapPhaseScene;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents the game phase in which the player swaps two items
 * form his inventory.
 */
public class InventorySwapPhase extends AbstractPhase  {

    private int firstSlot;
    private int currentTopSlot;
    private int highlightedSlot;
    private final int maxSlot = Settings.inventorySize - 3;
    HighlightSlotCommand highlightCommand0;
    HighlightSlotCommand highlightCommand1;
    HighlightSlotCommand highlightCommand2;
    ScrollDownCommand scrollDownCommand;
    ScrollUpCommand scrollUpCommand;
    GoBackCommand goBackCommand;
    ConfirmSwapCommand confirmSwapCommand;


    public InventorySwapPhase(@NotNull GameController controller, int firstSlot) {
        super(controller);

        this.firstSlot = firstSlot;
        highlightedSlot = -1;
        currentTopSlot = 0;
        highlightCommand0 = new HighlightSlotCommand(this, 0);
        highlightCommand1 = new HighlightSlotCommand(this, 1);
        highlightCommand2 = new HighlightSlotCommand(this, 2);
        scrollDownCommand = new ScrollDownCommand(this);
        scrollUpCommand = new ScrollUpCommand(this);
        goBackCommand = new GoBackCommand(this);
        confirmSwapCommand = new ConfirmSwapCommand(this);
        phaseScene = new InventorySwapPhaseScene(controller);
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
     * Returns the first inventory slot selected.
     */
    public int getFirstSlot() {
        return firstSlot;
    }

    /**
     * Returns the currently selected slot. -1 if none is selected.
     */
    public int getHighlightedSlot() {
        return highlightedSlot;
    }

    /**
     * returns the corresponding command
     */
    public ConfirmSwapCommand getConfirmSwapCommand() {
        return confirmSwapCommand;
    }

    /**
     * returns the corresponding command
     */
    public GoBackCommand getGoBackCommand() {
        return goBackCommand;
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
     * sets the currently selected slot.
     */
    public void setHighlightedSlot(int highlightedSlot) {
        this.highlightedSlot = highlightedSlot;
    }


    /**
     * returns the topmost visible inventory slot.
     */
    public int getCurrentTopSlot() {
        return currentTopSlot;
    }
}

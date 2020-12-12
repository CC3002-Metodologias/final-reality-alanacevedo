package com.github.alanacevedo.finalreality.controller.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.command.inventorySwapPhase.*;
import org.jetbrains.annotations.NotNull;

public class InventorySwapPhase extends AbstractPhase implements IPhase {
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
    }

    public void scrollUp() {
        if (currentTopSlot > 0) {
            highlightCommand0.scrollUp();
            highlightCommand1.scrollUp();
            highlightCommand2.scrollUp();
            currentTopSlot--;
        }
    }

    public void scrollDown() {
        if (currentTopSlot < maxSlot) {
            highlightCommand0.scrollDown();
            highlightCommand1.scrollDown();
            highlightCommand2.scrollDown();
            currentTopSlot++;
        }
    }

    public int getFirstSlot() {
        return firstSlot;
    }

    public int getHighlightedSlot() {
        return highlightedSlot;
    }

    public ConfirmSwapCommand getConfirmSwapCommand() {
        return confirmSwapCommand;
    }

    public GoBackCommand getGoBackCommand() {
        return goBackCommand;
    }

    public HighlightSlotCommand getHighlightCommand0() {
        return highlightCommand0;
    }

    public HighlightSlotCommand getHighlightCommand1() {
        return highlightCommand1;
    }

    public HighlightSlotCommand getHighlightCommand2() {
        return highlightCommand2;
    }

    public ScrollDownCommand getScrollDownCommand() {
        return scrollDownCommand;
    }

    public ScrollUpCommand getScrollUpCommand() {
        return scrollUpCommand;
    }

    public void setHighlightedSlot(int highlightedSlot) {
        this.highlightedSlot = highlightedSlot;
    }
}

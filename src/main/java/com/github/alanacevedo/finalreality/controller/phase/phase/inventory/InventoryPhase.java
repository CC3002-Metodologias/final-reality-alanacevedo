package com.github.alanacevedo.finalreality.controller.phase.phase.inventory;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.controller.phase.command.inventory.inventoryPhase.*;
import com.github.alanacevedo.finalreality.controller.phase.phase.AbstractPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import org.jetbrains.annotations.NotNull;

// Equip or swap inventory items

public class InventoryPhase extends AbstractPhase implements IPhase {



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
        name = "Inventory";

        goBackCommand = new GoBackCommand(this);
        highlightCommand0 = new HighlightSlotCommand(this, 0);
        highlightCommand1 = new HighlightSlotCommand(this, 1);
        highlightCommand2 = new HighlightSlotCommand(this, 2);
        equipCommand = new EquipCommand(this);
        scrollDownCommand = new ScrollDownCommand(this);
        scrollUpCommand = new ScrollUpCommand(this);
        swapCommand = new SwapCommand(this);
        currentTopSlot = 0;
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
    public ICommand getGoBackCommand() {
        return goBackCommand;
    }

    public void setHighLightedSlot(int slot) {
        highLightedSlot = slot;
    }

    public int getHighlightedSlot() {
        return highLightedSlot;
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

    public EquipCommand getEquipCommand() {
        return equipCommand;
    }

    public ScrollDownCommand getScrollDownCommand() {
        return scrollDownCommand;
    }

    public ScrollUpCommand getScrollUpCommand() {
        return scrollUpCommand;
    }

    public SwapCommand getSwapCommand() {
        return swapCommand;
    }

    public String getName() {
        return this.name;
    }

}

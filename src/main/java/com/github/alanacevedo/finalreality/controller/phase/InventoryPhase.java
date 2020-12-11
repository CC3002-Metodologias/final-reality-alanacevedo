package com.github.alanacevedo.finalreality.controller.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.controller.phase.command.inventoryPhase.*;
import org.jetbrains.annotations.NotNull;

// Equip or swap inventory items

public class InventoryPhase extends AbstractPhase implements IPhase{


    protected ICommand goBackCommand;

    protected HighlightSlotCommand highLightCommand0;
    protected HighlightSlotCommand highLightCommand1;
    protected HighlightSlotCommand highLightCommand2;
    protected EquipCommand equipCommand;
    protected ScrollDownCommand scrollDownCommand;



    protected ScrollUpCommand scrollUpCommand;
    private int currentTopSlot;
    private final int maxSlot = Settings.inventorySize - 3; // 3 because there will be 3 buttons
    int highLightedSlot = -1;

    public InventoryPhase(@NotNull GameController controller) {
        super(controller);
        goBackCommand = new GoBackCommand(this);
        highLightCommand0 = new HighlightSlotCommand(this, 0);
        highLightCommand1 = new HighlightSlotCommand(this, 1);
        highLightCommand2 = new HighlightSlotCommand(this, 2);
        equipCommand = new EquipCommand(this);
        scrollDownCommand = new ScrollDownCommand(this);
        scrollUpCommand = new ScrollUpCommand(this);
        currentTopSlot = 0;
    }

    public void scrollUp() {
        if (currentTopSlot > 0) {
            highLightCommand0.scrollUp();
            highLightCommand1.scrollUp();
            highLightCommand2.scrollUp();
            currentTopSlot--;
        }
    }

    public void scrollDown() {
        if (currentTopSlot < maxSlot) {
            highLightCommand0.scrollDown();
            highLightCommand1.scrollDown();
            highLightCommand2.scrollDown();
            currentTopSlot++;
        }
    }
    public ICommand getGoBackCommand() {
        return goBackCommand;
    }

    public void setHighLightedSlot(int slot) {
        highLightedSlot = slot;
    }

    public int getHighLightedSlot() {
        return highLightedSlot;
    }

    public HighlightSlotCommand getHighLightCommand0() {
        return highLightCommand0;
    }

    public HighlightSlotCommand getHighLightCommand1() {
        return highLightCommand1;
    }

    public HighlightSlotCommand getHighLightCommand2() {
        return highLightCommand2;
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
}

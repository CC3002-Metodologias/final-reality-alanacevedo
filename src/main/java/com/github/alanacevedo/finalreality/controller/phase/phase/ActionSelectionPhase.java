package com.github.alanacevedo.finalreality.controller.phase.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.controller.phase.command.actionSelectPhase.*;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.ActionSelectionPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.WaitingPhaseScene;
import org.jetbrains.annotations.NotNull;

public class ActionSelectionPhase extends AbstractPhase implements IPhase{
    //Select between Attack, Skill, Inventory
    //Skill solo tiene efecto si es un personaje mago

    protected AttackCommand attackCommand;
    protected ICommand magicCommand;
    protected InventoryCommand inventoryCommand;
    protected String name = "Action Selection";


    public ActionSelectionPhase(@NotNull GameController controller) {
        super(controller);
        attackCommand = new AttackCommand(this);
        magicCommand = new MagicCommand(this);
        inventoryCommand = new InventoryCommand(this);
        phaseScene = new ActionSelectionPhaseScene(controller);
    }

    @Override
    public AbstractPhaseScene getPhaseScene() {
        return phaseScene;
    }

    public AttackCommand getAttackCommand() {
        return attackCommand;
    }

    public ICommand getMagicCommand() {
        return magicCommand;
    }

    public InventoryCommand getInventoryCommand() {
        return inventoryCommand;
    }
    public String getName() {
        return this.name;
    }
}

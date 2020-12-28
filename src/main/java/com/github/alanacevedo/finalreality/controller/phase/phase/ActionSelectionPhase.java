package com.github.alanacevedo.finalreality.controller.phase.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.command.ICommand;
import com.github.alanacevedo.finalreality.controller.phase.command.actionSelectPhase.*;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.ActionSelectionPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.WaitingPhaseScene;
import org.jetbrains.annotations.NotNull;

public class ActionSelectionPhase extends AbstractPhase {
    //Select between Attack, Skill, Inventory
    //Skill solo tiene efecto si es un personaje mago

    protected AttackCommand attackCommand;
    protected ICommand magicCommand;
    protected InventoryCommand inventoryCommand;


    public ActionSelectionPhase(@NotNull GameController controller) {
        super(controller);
        phaseScene = new ActionSelectionPhaseScene(controller);
        attackCommand = new AttackCommand(this);
        magicCommand = new MagicCommand(this);
        inventoryCommand = new InventoryCommand(this);
    }

    @Override
    public AbstractPhaseScene getPhaseScene() {
        return phaseScene;
    }

    /**
     * Returns the command attack, which changes the game phase to AttackTargetSelectionPhase
     */
    public AttackCommand getAttackCommand() {
        return attackCommand;
    }

    /**
     * Returns the command attack, which changes the game phase to MagicSelectionPhase
     */
    public ICommand getMagicCommand() {
        return magicCommand;
    }

    /**
     * Returns the command attack, which changes the game phase to InventoryPhase
     */    public InventoryCommand getInventoryCommand() {
        return inventoryCommand;
    }
}

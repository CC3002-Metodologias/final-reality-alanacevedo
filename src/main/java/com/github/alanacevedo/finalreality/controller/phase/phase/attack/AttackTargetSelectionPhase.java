package com.github.alanacevedo.finalreality.controller.phase.phase.attack;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.command.attack.attackTargetSelectionPhase.*;
import com.github.alanacevedo.finalreality.controller.phase.phase.AbstractPhase;
import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;
import com.github.alanacevedo.finalreality.gui.phaseScene.attack.AttackTargetSelectionPhaseScene;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents
 */
public class AttackTargetSelectionPhase extends AbstractPhase implements IPhase {

    protected AttackEnemySlotCommand attackCommand0;
    protected AttackEnemySlotCommand attackCommand1;
    protected AttackEnemySlotCommand attackCommand2;
    protected GoBackCommand goBackCommand;

    public AttackTargetSelectionPhase(@NotNull GameController controller) {
        super(controller);

        goBackCommand = new GoBackCommand(this);
        attackCommand0 = new AttackEnemySlotCommand(this, 0);
        attackCommand1 = new AttackEnemySlotCommand(this, 1);
        attackCommand2 = new AttackEnemySlotCommand(this, 2);

        phaseScene = new AttackTargetSelectionPhaseScene(controller);
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
    public AttackEnemySlotCommand getAttackCommand0() {
        return attackCommand0;
    }

    /**
     * returns the corresponding command
     */
    public AttackEnemySlotCommand getAttackCommand1() {
        return attackCommand1;
    }

    /**
     * returns the corresponding command
     */
    public AttackEnemySlotCommand getAttackCommand2() {
        return attackCommand2;
    }

}

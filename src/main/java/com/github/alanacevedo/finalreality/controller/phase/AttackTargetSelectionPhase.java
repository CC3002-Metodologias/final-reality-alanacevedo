package com.github.alanacevedo.finalreality.controller.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.command.attackTargetSelectionPhase.*;
import org.jetbrains.annotations.NotNull;

public class AttackTargetSelectionPhase extends AbstractPhase implements IPhase {
    // There are max 3 enemy slots
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
    }

    public GoBackCommand getGoBackCommand() {
        return goBackCommand;
    }
    public AttackEnemySlotCommand getAttackCommand0() {
        return attackCommand0;
    }

    public AttackEnemySlotCommand getAttackCommand1() {
        return attackCommand1;
    }

    public AttackEnemySlotCommand getAttackCommand2() {
        return attackCommand2;
    }
}

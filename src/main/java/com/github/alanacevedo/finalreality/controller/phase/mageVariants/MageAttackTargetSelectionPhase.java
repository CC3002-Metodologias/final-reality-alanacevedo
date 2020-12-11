package com.github.alanacevedo.finalreality.controller.phase.mageVariants;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.phase.AttackTargetSelectionPhase;
import com.github.alanacevedo.finalreality.controller.phase.command.attackTargetSelectionPhase.MageGoBackCommand;
import org.jetbrains.annotations.NotNull;

public class MageAttackTargetSelectionPhase extends AttackTargetSelectionPhase {
    public MageAttackTargetSelectionPhase(@NotNull GameController controller) {
        super(controller);
        goBackCommand = new MageGoBackCommand(this);
    }
}

package com.github.alanacevedo.finalreality.controller.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import org.jetbrains.annotations.NotNull;

public class AttackTargetSelectionPhase extends AbstractPhase implements IPhase {
    public AttackTargetSelectionPhase(@NotNull GameController controller) {
        super(controller);
    }
    // Select enemy to attack, then attack.
}

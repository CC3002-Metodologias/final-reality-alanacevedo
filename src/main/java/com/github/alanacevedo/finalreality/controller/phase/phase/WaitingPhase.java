package com.github.alanacevedo.finalreality.controller.phase.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.WaitingPhaseScene;
import org.jetbrains.annotations.NotNull;

public class WaitingPhase extends AbstractPhase implements IPhase{

    public WaitingPhase(@NotNull GameController controller) {
        super(controller);
        name = "Waiting";
        phaseScene = new WaitingPhaseScene(controller);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public AbstractPhaseScene getPhaseScene() {
        return phaseScene;
    }
}

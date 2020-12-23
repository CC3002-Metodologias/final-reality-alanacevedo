package com.github.alanacevedo.finalreality.controller.phase.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.WaitingPhaseScene;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents the phase in battle in which there are no characters in the turns queue.
 */
public class WaitingPhase extends AbstractPhase implements IPhase{

    public WaitingPhase(@NotNull GameController controller) {
        super(controller);
        phaseScene = new WaitingPhaseScene(controller);
    }

    @Override
    public AbstractPhaseScene getPhaseScene() {
        return phaseScene;
    }
}

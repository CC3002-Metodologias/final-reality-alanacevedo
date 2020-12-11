package com.github.alanacevedo.finalreality.controller.phase;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import org.jetbrains.annotations.NotNull;

public class WaitingPhase extends AbstractPhase implements IPhase{

    public WaitingPhase(@NotNull GameController controller) {
        super(controller);
    }


}

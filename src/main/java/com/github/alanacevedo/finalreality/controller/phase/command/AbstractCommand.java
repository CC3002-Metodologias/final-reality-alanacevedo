package com.github.alanacevedo.finalreality.controller.phase.command;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;

public abstract class AbstractCommand {
    protected IPhase parentPhase;

    public AbstractCommand(IPhase phase) {
        parentPhase = phase;
    }

    public IPhase getParentPhase() {
        return parentPhase;
    }

}

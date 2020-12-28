package com.github.alanacevedo.finalreality.controller.phase.command;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;

public abstract class AbstractCommand implements ICommand {
    protected IPhase parentPhase;

    public AbstractCommand(IPhase phase) {
        parentPhase = phase;
    }

    @Override
    public IPhase getParentPhase() {
        return parentPhase;
    }



}

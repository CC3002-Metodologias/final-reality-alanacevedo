package com.github.alanacevedo.finalreality.controller.phase.command;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;

/**
 * Represents a command that does nothing.
 */
public class NullCommand extends AbstractCommand  {
    public NullCommand(IPhase phase) {
        super(phase);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void doAction() {

    }
}

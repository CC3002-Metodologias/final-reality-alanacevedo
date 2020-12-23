package com.github.alanacevedo.finalreality.controller.phase.command;

import com.github.alanacevedo.finalreality.controller.phase.phase.IPhase;

/**
 * This interface represents commands that will be linked to the GUI.
 */
public interface ICommand {

    /**
     * Returns the command's name or description
     */
    String getName();

    /**
     * Does the command's defined action.
     */
    void doAction();

    /**
     * Gets the phase this command belongs to.
     */
    IPhase getParentPhase();
}

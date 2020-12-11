package com.github.alanacevedo.finalreality.controller.phase.command;

import com.github.alanacevedo.finalreality.controller.phase.IPhase;

public interface ICommand {
    // the display will have different buttons, with each having a command
    // assigned to it, which will behave in a defined way.

    String getName();
    void doAction();
    IPhase getParentPhase();
}

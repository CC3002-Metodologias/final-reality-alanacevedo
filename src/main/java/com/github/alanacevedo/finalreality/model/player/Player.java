package com.github.alanacevedo.finalreality.model.player;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.model.character.ICharacter;

public class Player {
    private int partySize = Settings.partySize;
    private ICharacter[] party = new ICharacter[partySize];
    private Inventory inventory = new Inventory();
}

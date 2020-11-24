package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
    private int partySize = Settings.partySize;
    private int maxEnemies = Settings.maxEnemies;
    private Queue<ICharacter> turnsQueue = new LinkedBlockingQueue<>();

}

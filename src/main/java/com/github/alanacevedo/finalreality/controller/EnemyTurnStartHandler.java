package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class is in charge of managing notifications of the start of a PC's turn.
 */
public class EnemyTurnStartHandler implements PropertyChangeListener {
    private final GameController controller;

    /**
     * Initializes an instance of this handler
     * @param controller GameController that will make use of this handler.
     */
    public EnemyTurnStartHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
            controller.enemyTurn((Enemy) event.getSource());
    }
}
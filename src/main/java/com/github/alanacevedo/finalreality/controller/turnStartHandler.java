package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class turnStartHandler implements PropertyChangeListener {
    private GameController controller;

    public turnStartHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("enemyTurnStart")) {
            controller.enemyTurn((Enemy) event.getSource());
        } else if (event.getPropertyName().equals("playerCharTurnStart")) {
            controller.playerCharacterTurn((IPlayableCharacter) event.getSource());
        }
    }
}

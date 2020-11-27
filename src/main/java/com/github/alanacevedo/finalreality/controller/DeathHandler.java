package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DeathHandler implements PropertyChangeListener{
    private final GameController controller;

    public DeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("enemyDeath")) {
            controller.enemyDeath();
            if (controller.getAliveEnemies() == 0) {
                controller.endBattle();
            }
        } else if (event.getPropertyName().equals("playerCharacterDeath")) {
            controller.playerCharacterDeath();
            if (controller.getAlivePlayerCharacters() == 0) {
                controller.endBattle();
            }
        }
    }

}
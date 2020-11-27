package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DeathHandler implements PropertyChangeListener{
    private final GameController controller;
    private int aliveEnemies;
    private int alivePlayerCharacters;

    public DeathHandler(GameController controller) {
        this.controller = controller;
        alivePlayerCharacters = Settings.partySize;
    }

    public void updateEnemyGroupSize() {
        aliveEnemies = controller.getEnemyGroup().getCurrentEnemies();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("enemyDeath")) {
            aliveEnemies--;
            if (aliveEnemies == 0) {
                controller.endBattle();
            }
        } else if (event.getPropertyName().equals("playerCharacterDeath")) {
            alivePlayerCharacters--;
            if (alivePlayerCharacters == 0) {
                controller.endBattle();
            }
        }
    }

}
package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class is in charge of handling notifications of an enemy dying.
 */
public class EnemyDeathHandler implements PropertyChangeListener{
    private final GameController controller;

    /**
     * Initializes an instance of this handler
     * @param controller GameController that will make use of this handler.
     */
    public EnemyDeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        controller.enemyDeath();
    }

}
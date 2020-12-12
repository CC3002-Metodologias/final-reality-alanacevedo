package com.github.alanacevedo.finalreality.controller.handler;
import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class is in charge of handling notifications of a party character dying.
 */
public class PlayerCharDeathHandler implements PropertyChangeListener{
    private final GameController controller;

    /**
     * Initializes an instance of this handler
     * @param controller GameController that will make use of this handler.
     */
    public PlayerCharDeathHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        controller.playerCharacterDeath();
    }

}
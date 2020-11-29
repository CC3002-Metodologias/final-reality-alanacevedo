package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class is in charge of managing notifications of characters being ready to be added to the turns queue.
 */
public class AddToQueueHandler implements PropertyChangeListener{
    private final GameController controller;

    /**
     * Initializes an instance of this handler
     * @param controller GameController that will make use of this handler.
     */
    public AddToQueueHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        controller.addToQueue((ICharacter) event.getSource());
    }

}

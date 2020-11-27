package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class addToQueueHandler implements PropertyChangeListener{
    private final GameController controller;

    public addToQueueHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("addToQueue")) {
            controller.addToQueue((ICharacter) event.getSource());
        }
    }

}

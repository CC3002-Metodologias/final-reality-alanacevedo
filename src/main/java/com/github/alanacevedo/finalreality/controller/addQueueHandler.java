package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class addQueueHandler implements PropertyChangeListener{
    private GameController controller;

    public addQueueHandler(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("addToQueue")) {
            controller.addToQueue((ICharacter) event.getSource());
        }
    }

}

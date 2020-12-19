package com.github.alanacevedo.finalreality.gui;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.gui.phaseScene.AbstractPhaseScene;
import com.github.alanacevedo.finalreality.gui.phaseScene.WaitingPhaseScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Michael Alan Acevedo Salazar
 */
public class FinalReality extends Application {
  private static final String RESOURCE_PATH = "src/main/resources/";
  private final GameController controller = new GameController();


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final Reality");
    controller.setupStandardBattle();

    Group root = controller.getPhase().getPhaseScene().getRoot();
    Scene scene = new Scene(root, Settings.width, Settings.height);
    controller.setUiScene(scene);
    primaryStage.setScene(scene);
    setupTimer();
    primaryStage.show();
  }

  private void setupTimer() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        controller.getPhase().getPhaseScene().handleTimer();
      }
    };
    timer.start();
  }

}
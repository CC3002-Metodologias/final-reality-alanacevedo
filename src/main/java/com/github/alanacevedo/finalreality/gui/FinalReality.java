package com.github.alanacevedo.finalreality.gui;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
  private GameController controller = new GameController();
  private Label phaseLabel = new Label();
  private Label queueSizeLabel = new Label();
  private Label characterNameLabel = new Label();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    primaryStage.setTitle("Final Reality");
    int width= 800;
    int height = 600;

    controller.setupStandardBattle();

    Group root = new Group();
    Scene scene = new Scene(root, width, height);

    root.getChildren().add(phaseLabel);
    phaseLabel.setLayoutX(10);
    phaseLabel.setLayoutY(10);

    root.getChildren().add(queueSizeLabel);
    queueSizeLabel.setLayoutX(10);
    queueSizeLabel.setLayoutY(30);

    root.getChildren().add(characterNameLabel);
    characterNameLabel.setLayoutX(10);
    characterNameLabel.setLayoutY(50);

    setupTimer();
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private void setupTimer() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        phaseLabel.setText(controller.getPhase().getName() + "Phase");
        queueSizeLabel.setText(String.valueOf(controller.getTurnsQueue().size()));
        IPlayableCharacter currentChar = controller.getCurrentChar();
        if (currentChar != null) {
          characterNameLabel.setText(currentChar.getName());
        } else {
          characterNameLabel.setText("");
        }

      }
    };
    timer.start();
  }
}
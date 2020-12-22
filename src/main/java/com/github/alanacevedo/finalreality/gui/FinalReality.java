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
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

import java.nio.file.Paths;

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
  private MediaPlayer mediaPlayer;
  private Group phaseRoot;
  private Group root = new Group();
  private Scene scene;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final Reality");
    controller.setupStandardBattle();

    scene = new Scene(root, Settings.width, Settings.height);
    primaryStage.setScene(scene);
    phaseRoot = controller.getPhase().getPhaseScene().getRoot();
    root.getChildren().add(phaseRoot);

    String s = Settings.resourcePath+"bg_music.mp3";
    Media backgroundMusic = new Media(Paths.get(s).toUri().toString());
    mediaPlayer = new MediaPlayer(backgroundMusic);
    mediaPlayer.setVolume(0.05);
    mediaPlayer.play();

    setupTimer();
    primaryStage.show();
  }

  private void setupTimer() {

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        controller.getPhase().getPhaseScene().handleTimer();
        scene.setRoot(controller.getPhase().getPhaseScene().getRoot());
      }
    };
    timer.start();
  }

}
package com.github.alanacevedo.finalreality.gui;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.controller.Settings;
import com.github.alanacevedo.finalreality.gui.phaseScene.commonElements.CommonBattlePhaseElements;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;

import java.nio.file.Paths;

/**
 * Main entry point for the application.
 * Initializes a game controller, launches common elements, and then starts a battle.
 *
 * @author Ignacio Slater Muñoz.
 * @author Michael Alan Acevedo Salazar
 */
public class FinalReality extends Application {
  private final GameController controller = new GameController();
  private MediaPlayer mediaPlayer;
  private final Group root = new Group();
  private Scene scene;
  private CommonBattlePhaseElements commonElements;
  private Group commonElementsNode;
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final Reality");
    controller.setupStandardBattle();

    scene = new Scene(root, Settings.width, Settings.height);
    commonElements = new CommonBattlePhaseElements(controller);
    commonElementsNode = commonElements.getNode();
    root.getChildren().add(commonElementsNode);
    root.getChildren().add(new Group());
    primaryStage.setScene(scene);


    String s = Settings.resourcePath+"bg_music.mp3";
    Media backgroundMusic = new Media(Paths.get(s).toUri().toString());
    mediaPlayer = new MediaPlayer(backgroundMusic);
    mediaPlayer.setVolume(0.05);
    mediaPlayer.play();

    setupTimer();
    primaryStage.show();
  }

  /**
   * Handles varying interface elements.
   */
  private void setupTimer() {

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        controller.getPhase().getPhaseScene().handleTimer();
        root.getChildren().set(1, controller.getPhase().getPhaseScene().getRoot());
        commonElements.handleTimer();
      }
    };
    timer.start();
  }

}
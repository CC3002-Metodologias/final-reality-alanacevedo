package com.github.alanacevedo.finalreality.gui.nodes;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HealthBar {

    private double maxHp;
    private double currentHp;
    private int width = 30;
    private int height = 5;
    private Group root = new Group();
    Rectangle greenRectangle;


    public HealthBar(double maxHp) {
        this.maxHp = maxHp;
        currentHp = maxHp;

        Rectangle redRectangle = new Rectangle();
        redRectangle.setWidth(width);
        redRectangle.setHeight(height);
        redRectangle.setFill(Color.RED);

        greenRectangle = new Rectangle();
        greenRectangle.setWidth((currentHp/maxHp)*width);
        greenRectangle.setHeight(height);
        greenRectangle.setFill(Color.GREEN);
        root.getChildren().addAll(redRectangle,greenRectangle);

    }

    public void handleTimer(double hp) {
        greenRectangle.setWidth((hp/maxHp)*width);
    }
    public Group getNode() {
        return root;
    }
}

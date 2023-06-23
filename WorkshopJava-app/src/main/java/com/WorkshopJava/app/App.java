package com.WorkshopJava.app;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Map;

public class App extends GameApplication {
    private Entity player;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void initSettings(GameSettings setting) {
        setting.setWidth(800);
        setting.setHeight(600);
        setting.setTitle("WorkshopJava");
    }
    @Override
    public void initGame() {
        player = FXGL.entityBuilder()
                .at(20, 20)
                .view(new Rectangle(25, 25, Color.BLUE))
                .buildAndAttach();
        FXGL.getGameWorld().addEntityFactory(new Factory());
        for (int x = 0; x < 10; x++)
            FXGL.spawn("enemy", Math.random() * 800, Math.random() * 600);
    }
    @Override
    public void initInput() {
        FXGL.onKeyDown(KeyCode.UP, () -> {
            player.setPosition(player.getX(), player.getY() - 10);
            FXGL.inc("pixelsMoved", - 10);
        });
        FXGL.onKeyDown(KeyCode.DOWN, () -> {
            player.setPosition(player.getX(), player.getY() + 10);
            FXGL.inc("pixelsMoved", + 10);
        });
        FXGL.onKeyDown(KeyCode.RIGHT, () -> {
            player.setPosition(player.getX() + 10, player.getY());
            FXGL.inc("pixelsMoved", + 10);
        });
        FXGL.onKeyDown(KeyCode.LEFT, () -> {
            player.setPosition(player.getX() - 10, player.getY());
            FXGL.inc("pixelsMoved", - 10);
        });
    }
    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelMoved", 0);
    }
    @Override
    protected void initUI() {
        Text textPixels = new Text("Pos");
        textPixels.setTranslateX(400);
        textPixels.setTranslateY(20);
        FXGL.getGameScene().addUINode(textPixels);
    }
}

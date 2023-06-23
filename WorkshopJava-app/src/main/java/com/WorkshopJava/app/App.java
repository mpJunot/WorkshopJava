package com.WorkshopJava.app;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class App extends GameApplication {
    EntityBuilder p_builder;
    EntityBuilder e_builder;
    Entity player;
    Entity enemy;
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
        p_builder = FXGL.entityBuilder();
        p_builder.at(20, 20);
        p_builder.view(new Rectangle(25, 25, Color.BLUE));
        player = p_builder.buildAndAttach();
        FXGL.getGameWorld().addEntityFactory(new Factory());
        FXGL.spawn("enemy", 10, 10);
        FXGL.spawn("enemy", 50, 20);
    }
    @Override
    public void initInput() {
        FXGL.onKeyDown(KeyCode.UP, () -> {
            player.setPosition(player.getX(), player.getY() - 10);
        });
        FXGL.onKeyDown(KeyCode.DOWN, () -> {
            player.setPosition(player.getX(), player.getY() + 10);
        });
        FXGL.onKeyDown(KeyCode.RIGHT, () -> {
            player.setPosition(player.getX() + 10, player.getY());
        });
        FXGL.onKeyDown(KeyCode.LEFT, () -> {
            player.setPosition(player.getX() - 10, player.getY());
        });
    }
}

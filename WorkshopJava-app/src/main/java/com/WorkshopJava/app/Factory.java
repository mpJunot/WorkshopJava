package com.WorkshopJava.app;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import com.almasb.fxgl.entity.Entity;

public class Factory implements EntityFactory {
    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        return FXGL.entityBuilder(data)
            .view(new Rectangle(25, 25, Color.RED))
            .build();
    }
}

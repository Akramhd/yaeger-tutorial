package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class SharkySpirite extends SpriteEntity {
    protected SharkySpirite(Coordinate2D initialLocation) {
        super("sprites/sharky.png", initialLocation);
    }
}

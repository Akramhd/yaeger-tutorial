package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.impl.*;

public class SharkySpirite extends DynamicSpriteEntity {
    protected SharkySpirite(Coordinate2D initialLocation) {
        super("sprites/sharky.png", initialLocation, new Size(50,50),1,19);
        setAutoCycle(10);
    }
}

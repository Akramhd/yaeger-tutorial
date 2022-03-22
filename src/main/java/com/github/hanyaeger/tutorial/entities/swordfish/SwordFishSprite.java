package com.github.hanyaeger.tutorial.entities.swordfish;


import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.Coordinate2D;

public class SwordFishSprite extends SpriteEntity  {

    public SwordFishSprite(final Coordinate2D location) {
        super("sprites/swordfish.png", location);
    }
}
package com.github.hanyaeger.tutorial.hitbox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.sharky.Sharky;
import javafx.scene.paint.Color;

import java.util.Random;

public class SharkyHitbox extends RectangleEntity implements Collider , Collided {
    Sharky sharky;
        public SharkyHitbox(final Coordinate2D initialPosition,Sharky sharky) {
            super(initialPosition);
            setWidth(60);
            setHeight(2);
            setFill(Color.TRANSPARENT);
            this.sharky=sharky;
        }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Hanny){
            sharky.setAnchorLocationY(
                    new Random().nextInt((int)(getSceneHeight() - getHeight()))
            );
        }
    }
}


package com.github.hanyaeger.tutorial.entities.bubble;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.paint.Color;

public class AirBubble extends DynamicCircleEntity implements Collided ,Bubbel , SceneBorderCrossingWatcher {
    public AirBubble(Coordinate2D initialLocation, double speed) {
        super(initialLocation);
        setFill(Color.LIGHTBLUE);
        setRadius(10);
        setOpacity(1);
        setMotion(speed,180d);
    }

    @Override
    public void onCollision(Collider collider) {
        var popSound = new SoundClip("audio/pop.mp3");
        popSound.play();
        remove();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        switch (sceneBorder){
            case TOP:
                remove();
            default:
                break;
        }
    }
}

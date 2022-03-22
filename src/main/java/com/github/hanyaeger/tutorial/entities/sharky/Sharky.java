package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.swordfish.HitBox;

import java.util.Random;

public class Sharky extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {
    public Sharky(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(2, 90d);

    }

    @Override
    protected void setupEntities() {
        var sharky = new SharkySpirite(
                new Coordinate2D(0,0)
        );
        var hitbox = new HitBox(
                new Coordinate2D(10,40)

        );

        addEntity(hitbox);
        addEntity(sharky);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
    }
}

package com.github.hanyaeger.tutorial.entities.sharky;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.hitbox.SharkyHitbox;

public class Sharky extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {
    public Sharky(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(3, 90d);
    }

    @Override
    protected void setupEntities() {
        var sharky = new SharkySpirite(
                new Coordinate2D(0,0)
        );
        var hitbox = new SharkyHitbox(
                new Coordinate2D(10,40),this
        );
        addEntity(hitbox);
        addEntity(sharky);

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(0.0D);
    }

}



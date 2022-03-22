package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class SwordFish extends DynamicCompositeEntity implements SceneBorderCrossingWatcher{


    public SwordFish(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(2, 270d);

    }

    @Override
    protected void setupEntities() {
        var swordFishEntities = new SwordFishSprite (
        new Coordinate2D(0,0)
);
        var hitbox = new HitBox (
                new Coordinate2D(10,40)

        );



    addEntity(swordFishEntities);
    addEntity(hitbox);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(getSceneWidth());
    }
}

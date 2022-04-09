package com.github.hanyaeger.tutorial.scene;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.buttons.QuitButton;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.sharky.Sharky;
import com.github.hanyaeger.tutorial.entities.swordfish.SwordFish;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.spawners.BubbleSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    private Waterworld waterworld;
    public GameLevel(Waterworld waterworld){
        this.waterworld=waterworld;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
     var swordfish = new SwordFish(
             new Coordinate2D(getWidth() / 2, getHeight() / 2)
     );

      var  health = new HealthText(
             new Coordinate2D(getWidth()/3,getHeight()/4)
     );

      var bubblesPopped = new BubblesPoppedText(
              new Coordinate2D(getWidth()/3,getHeight()/4)
      );
        Hanny hanny;
        hanny = new Hanny(
             new Coordinate2D (getWidth() -getWidth(), getHeight()-getHeight()),
                health,waterworld,bubblesPopped
        );

        var quitButton = new QuitButton(
                new Coordinate2D(getWidth() /2, getHeight()-getHeight()+10), waterworld
        );
        quitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var sharky = new Sharky(
                new Coordinate2D(getWidth()/4,getHeight()/4)
        );

        addEntity(quitButton);
        addEntity(swordfish);
        addEntity(hanny);
        addEntity(health);
        addEntity(sharky);
    }

    @Override
    public void setupEntitySpawners() {
        var spawner = new BubbleSpawner(getWidth(),getHeight()/1);
        addEntitySpawner(spawner);
    }
}

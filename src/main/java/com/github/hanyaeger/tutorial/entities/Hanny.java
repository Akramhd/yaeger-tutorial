package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.entities.bubble.AirBubble;
import com.github.hanyaeger.tutorial.entities.text.BubblesPoppedText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener,
        SceneBorderTouchingWatcher, Newtonian, Collided,Collider
{
    private Waterworld wateworld;
    private HealthText healthText;
    private BubblesPoppedText bubblesPoppedText;
    private int health = 10;
    int bubblesPopped=0;

    public Hanny(Coordinate2D location, HealthText healthText, Waterworld wateworld,BubblesPoppedText bubblesPoppedText){
        super("sprites/hanny.png", location ,new Size(20,40),1,2);

        this.wateworld=wateworld;
        this.healthText = healthText;
        this.bubblesPoppedText=bubblesPoppedText;
        healthText.setHealthText(health);
        setGravityConstant(0.005);
        setFrictionConstant(0.04);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(3,0d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collidingObject){
        if (collidingObject instanceof AirBubble){
            bubblesPoppedText.setbubblesPoppedText(++bubblesPopped);
        } else {
            healthText.setHealthText(--health);

            if (health == 0){
                wateworld.setActiveScene(2);
            } else {
                setAnchorLocation(new Coordinate2D(
                        new Random().nextInt((int)(getSceneWidth() - getWidth())),
                        new Random().nextInt((int)(getSceneHeight() - getHeight()))));
            }
        }
    }


}

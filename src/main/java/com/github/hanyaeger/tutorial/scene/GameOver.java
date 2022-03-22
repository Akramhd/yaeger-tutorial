package com.github.hanyaeger.tutorial.scene;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.buttons.PlayAgain;
import com.github.hanyaeger.tutorial.buttons.QuitButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends StaticScene {
    private Waterworld waterworld;
    public GameOver( Waterworld waterworld){
        this.waterworld= waterworld;
    }
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "game over"

        );

        var playButton = new PlayAgain(
                new Coordinate2D(getWidth() / 2, getHeight() / 3), waterworld
        );
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.DARKRED);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameOverText);

        var quitButton = new QuitButton(
                new Coordinate2D(getWidth() /2, getHeight()-getHeight()+10), waterworld
        );
        quitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(quitButton);
        playButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(playButton);

    }
}

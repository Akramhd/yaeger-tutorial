package com.github.hanyaeger.tutorial.scene;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.buttons.QuitButton;
import com.github.hanyaeger.tutorial.buttons.StartButton;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {
    private Waterworld waterworld;

    public TitleScene(Waterworld waterworld){
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var waterworldText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Waterworld"

        );

        var startbutton = new StartButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 3), waterworld
        );
        waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterworldText.setFill(Color.DARKBLUE);
        waterworldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(waterworldText);

        var quitButton = new QuitButton(
                new Coordinate2D(getWidth() /2, getHeight()-getHeight()+10), waterworld
        );
        quitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(quitButton);

        startbutton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startbutton);

    }
}

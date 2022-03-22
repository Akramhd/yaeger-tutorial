package com.github.hanyaeger.tutorial.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.tutorial.Waterworld;
import com.github.hanyaeger.tutorial.scene.MouseEnterListener;
import com.github.hanyaeger.tutorial.scene.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuitButton extends TextEntity implements MouseButtonPressedListener,
        MouseEnterListener, MouseExitListener {
    private Waterworld waterworld;
    public QuitButton(Coordinate2D initialLocation, Waterworld waterworld) {
        super(initialLocation, "Quit");
        this.waterworld=waterworld;
        setFill(Color.RED);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        waterworld.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.PURPLE);
        setCursor(Cursor.DEFAULT);
    }
}

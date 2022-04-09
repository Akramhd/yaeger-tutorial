package com.github.hanyaeger.tutorial.entities.bubble;

import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.Node;

import java.util.Optional;

public interface Bubbel extends Collider {
    @Override
    public Optional<? extends Node> getNode() ;


}

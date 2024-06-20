package com.example.miniwars;

import javafx.scene.paint.Color;

public enum Terrain {
    GRASS{
        @Override
        Color getColor() {
            return Color.LIGHTGREEN;
        }

        @Override
        int getMovementCost() {
            return 1;
        }
    };

    abstract Color getColor();
    abstract int getMovementCost();
}

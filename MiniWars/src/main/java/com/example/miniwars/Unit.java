package com.example.miniwars;

import javafx.scene.Parent;

public interface Unit {
    public int getX();
    public int getY();
    public void toggleHighlight();
    public int getMovement();
    public Faction getFaction();
    public void move(Tile t);
}

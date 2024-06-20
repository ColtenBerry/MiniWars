package com.example.miniwars;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Swordsman extends Parent implements Unit{
    private MiniWars game = MiniWars.getGame();
    private int x, y;
    private int movement = 5;
    private final Faction faction;
    private Circle c, h;
    private boolean highlighted = false;

    public Swordsman(Faction faction, int x, int y) {
        this.faction = faction;
        this.x = x;
        this.y = y;

        draw();
    }

    public void draw() {
        int tile_size = game.getTile_size();

        //draw unit visual
        c = new Circle();
        c.setFill(faction.getColor());
        c.setRadius(tile_size * .35);
        c.setCenterX(tile_size * .5 + tile_size * x);
        c.setCenterY(tile_size * .5 + tile_size * y);
        getChildren().add(c);

        //draw highlight circle
        h = new Circle();
        h.setFill(Color.GREENYELLOW);
        h.setRadius(tile_size * .35);
        h.setCenterX(tile_size * .5 + tile_size * x);
        h.setCenterY(tile_size * .5 + tile_size * y);
        h.setOpacity(0); //starts off invisible
        getChildren().add(h);


    }

    public void clear() {
        getChildren().remove(c);
        getChildren().remove(h);
    }

    public void toggleHighlight() {
        if (highlighted) {
            //turn off highlight
            highlighted = false;
            h.setOpacity(0);
        }
        else {
            //turn on highlight
            highlighted = true;
            h.setOpacity(.5);
        }
    }

    @Override
    public int getMovement() {
        return movement;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Faction getFaction() {
        return faction;
    }

    @Override
    public void move(Tile t) {
        x = t.getX();
        y = t.getY();
        clear();
        draw();
    }

    public String toString() {
        return "X: " + x + ", Y: " + y + "; Faction: " + faction + "; Swordsman";
    }
}

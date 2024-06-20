package com.example.miniwars;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Parent {
    private Terrain terrain;
    private Unit unit;
    private int x, y;
    private int tile_size;
    private Rectangle r, h;

    public Tile(Terrain terrain, int x, int y, int tile_size) {
        this.terrain = terrain;
        this.x = x;
        this.y = y;
        this.tile_size = tile_size;

        draw();

    }

    public void draw() {
        //draw tile
        r = new Rectangle(x * tile_size, y * tile_size, tile_size, tile_size);
        r.setFill(terrain.getColor());
        r.setStroke(Color.BLACK);
        getChildren().add(r);

        //draw highlight tile
        //draw tile
        h = new Rectangle(x * tile_size, y * tile_size, tile_size, tile_size);
        h.setFill(terrain.getColor());
        h.setStroke(Color.BLACK);
        h.setOpacity(0);
        getChildren().add(h);

    }

    public void highlight(Color highlight_color) {
        h.setOpacity(.5);
        h.setFill(highlight_color);
    }


    public void clearHighlight() {
        h.setOpacity(0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Unit getUnit() {
        return unit;
    }
    public void addUnit(Unit unit) {
        this.unit = unit;

        //update visual
        getChildren().add((Node) unit);
    }
    public void clearUnit() {
        this.unit = null;

        //update visual
        getChildren().remove((Node) unit);
    }
    public boolean containsUnit() {
        return unit != null;
    }
    public Terrain getTerrain() {
        return terrain;
    }

    public String toString() {
        return "X: " + x + ", Y: " + y + "; Terrain: " + terrain + "; Units: " + unit;
    }
}

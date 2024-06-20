package com.example.miniwars;

import javafx.scene.Parent;

public class Board extends Parent {
    private Tile[][] board;
    private int width;
    private int height;

    public Board(int width, int height, int tile_size) {
        this.width = width;
        this.height = height;
        board = new Tile[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Tile t = new Tile(Terrain.GRASS, i, j, tile_size);
                board[i][j] = t;
            }
        }
    }
    public void draw() {
        for (Tile[] column: board) {
            for (Tile t: column) {
                getChildren().add(t);
            }
        }
    }

    public Tile getTile(int x, int y) {
        return board[x][y];
    }
}

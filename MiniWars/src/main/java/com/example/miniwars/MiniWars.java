package com.example.miniwars;

import java.util.ArrayList;

public class MiniWars {
    private static final MiniWars game = new MiniWars();
    public Faction faction;
    private Board board;
    private ArrayList<Faction> factions;
    private int turn_number;
    private final int game_width = 600;
    private final int game_height = 600;
    private final int tile_size = 40;
    private final int numTilesWidth = (int) game_width / game_height;
    private final int numTilesHeight = (int) game_height / tile_size;

    public MiniWars() {
        board = new Board(game_width, game_height, tile_size);
    }
    public static MiniWars getGame() {
        return game;
    }
    public Board getBoard() {
        return board;
    }
    public int getTile_size() {
        return tile_size;
    }

    public int getNumTilesWidth() {
        return numTilesWidth;
    }

    public int getNumTilesHeight() {
        return numTilesHeight;
    }
}

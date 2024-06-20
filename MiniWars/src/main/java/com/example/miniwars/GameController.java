package com.example.miniwars;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.SynchronousQueue;

public class GameController {
    MiniWars game = MiniWars.getGame();
    Board board = game.getBoard();
    int tile_size = game.getTile_size();
    @FXML
    Pane gamePane;
    Tile previous_tile;
    Tile selected_tile;
    Unit selected_unit;

    @FXML
    private void initialize() {
        board.draw();
        gamePane.getChildren().add(board);
        spawnUnit(new Swordsman(Faction.PLAYER, 2, 2));
        spawnUnit(new Swordsman(Faction.BOT1, 4, 7));
    }

    private void spawnUnit(Unit unit) {
        int x = unit.getX();
        int y = unit.getY();
        Faction faction = unit.getFaction();


        board.getTile(x, y).addUnit(unit); //place the unit on the board

        faction.addUnit(unit); //update game lists
    }

    @FXML
    private void click(MouseEvent e) {
        double mouseX = e.getX();
        double mouseY = e.getY();
        int x = (int) mouseX / tile_size;
        int y = (int) mouseY / tile_size;
        selected_tile = board.getTile(x, y);
        System.out.println(selected_tile);
        select_tile();
    }

    /*
    if tile is empty:
        display terrain information
    elif tile has building but no unit
        display building information
    elif tile has unit
        select unit / display unit information
     */
    private void select_tile() {
        if (previous_tile == null) {

        }
        else if (previous_tile.){

        }
        selected_unit = selected_tile.getUnit();
        if (selected_unit == null) {
            //display stuff
            System.out.println("No Unit");
        }
        else {
            //highlight the unit
            selected_unit.toggleHighlight();

            //highlight potential moves
            highlightPotentialMoves(selected_tile);

        }
    }

    private void moveUnit(Unit unit, Tile ending_tile) {
        if (ending_tile.containsUnit()) {
            System.out.println("Ending Tile: " + ending_tile + " already contains unit " + ending_tile.getUnit());
        }
        Tile starting_tile = board.getTile(unit.getX(), unit.getY());
        unit.move(ending_tile);
        starting_tile.clearUnit();
        ending_tile.addUnit(unit);

    }



    ArrayList<Tile> potential_moves_lst = new ArrayList<>();
    private void highlightPotentialMoves(Tile selected_tile) {

        getPotentialMoves(selected_tile.getUnit().getMovement(), selected_tile);

        for(Tile t: potential_moves_lst) {
            t.highlight(Color.GREENYELLOW);
        }
    }
    private void getPotentialMoves(int movement, Tile t) {
//        System.out.println("Tile: " + t);
        if (!t.containsUnit() && !potential_moves_lst.contains(t)) {
            potential_moves_lst.add(t);
        }

        Tile above;
        Tile below;
        Tile left;
        Tile right;

        if (t.getX() < 20) {
            right = board.getTile(t.getX() + 1, t.getY());
//            System.out.println("Right: " + right);
            if (movement >= right.getTerrain().getMovementCost() && (right.getUnit() == null || right.getUnit().getFaction() == selected_unit.getFaction())) {
                getPotentialMoves(movement - right.getTerrain().getMovementCost(), right);
            }
        }


        if (t.getY() > 0) {
            above = board.getTile(t.getX(), t.getY() - 1);
//            System.out.println("Above: " + above);
            if (movement >= above.getTerrain().getMovementCost() && (above.getUnit() == null || above.getUnit().getFaction() == selected_unit.getFaction())) {
                getPotentialMoves(movement - above.getTerrain().getMovementCost(), above);
            }

        }
        if (t.getY() < game.getNumTilesHeight()) {
            below = board.getTile(t.getX(), t.getY() + 1);
//            System.out.println("Below: " + below);
            if (movement >= below.getTerrain().getMovementCost() && (below.getUnit() == null || below.getUnit().getFaction() == selected_unit.getFaction())) {
                getPotentialMoves(movement - below.getTerrain().getMovementCost(), below);

            }
        }
        if (t.getX() > 0) {
            left = board.getTile(t.getX() - 1, t.getY());
//            System.out.println("Left: " + left);
            if (movement >= left.getTerrain().getMovementCost() && (left.getUnit() == null || left.getUnit().getFaction() == selected_unit.getFaction())) {
                getPotentialMoves(movement - left.getTerrain().getMovementCost(), left);

            }
        }
    }
}
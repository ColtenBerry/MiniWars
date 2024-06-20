package com.example.miniwars;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public enum Faction {
    PLAYER{
        ArrayList<Unit> units = new ArrayList<>();
        @Override
        Color getColor() {
            return Color.DODGERBLUE;
        }

        @Override
        ArrayList<Unit> getUnits() {
            return units;
        }

        @Override
        void addUnit(Unit unit) {
            units.add(unit);
        }

        @Override
        void deleteUnit(Unit unit) {
            units.remove(unit);
        }
    },
    BOT1{
        ArrayList<Unit> units = new ArrayList<>();

        @Override
        Color getColor() {
            return Color.RED;
        }
        @Override
        ArrayList<Unit> getUnits() {
            return units;
        }

        @Override
        void addUnit(Unit unit) {
            units.add(unit);
        }

        @Override
        void deleteUnit(Unit unit) {
            units.remove(unit);
        }

    },
    BOT2{
        ArrayList<Unit> units = new ArrayList<>();

        @Override
        Color getColor() {
            return Color.DARKBLUE;
        }
        @Override
        ArrayList<Unit> getUnits() {
            return units;
        }

        @Override
        void addUnit(Unit unit) {
            units.add(unit);
        }

        @Override
        void deleteUnit(Unit unit) {
            units.remove(unit);
        }

    };

    abstract Color getColor();
    abstract ArrayList<Unit> getUnits();
    abstract void addUnit(Unit unit);
    abstract void deleteUnit(Unit unit);
}

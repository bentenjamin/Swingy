package com.bwebb.swingy.model.map;

public class Coordinates {
    private int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void moveBy(Coordinates offset) {
        this.x += offset.x;
        this.y += offset.y;
    }
}

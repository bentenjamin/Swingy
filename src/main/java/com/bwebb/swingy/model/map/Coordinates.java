package com.bwebb.swingy.model.map;

public class Coordinates {
    private int x = -1, y = -1;

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

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setCoords(int x, int y) {
        setX(x);
        setY(y);
    }

    public void moveBy(Coordinates offset) {
        this.x += offset.x;
        this.y += offset.y;
    }
}

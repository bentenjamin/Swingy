package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.GameStateParent;

import java.util.HashMap;

import static com.bwebb.swingy.controller.GameController.*;
import static com.bwebb.swingy.model.map.MapHandler.*;

public class Exploring extends GameStateParent {
    private HashMap<Integer, Runnable> tileActions = new HashMap<Integer, Runnable>();

    public Exploring() {
        tileActions.put(mapNothing, this::runNothing);
        tileActions.put(mapBlockage, this::runBlockage);
        tileActions.put(mapEnemy, this::runEnemy);
        tileActions.put(-1, this::runOutOfMap);

        commands.put("w", this::tryMoveUp);
        commands.put("a", this::tryMoveLeft);
        commands.put("s", this::tryMoveDown);
        commands.put("d", this::tryMoveRight);
    }

    private void tryMoveUp() {
        tileActions.get(mapHandler.getTile(player.getX(), player.getY() + 1)).run();
    }

    private void tryMoveLeft() {
        tileActions.get(mapHandler.getTile(player.getX() - 1, player.getY())).run();
    }

    private void tryMoveDown() {
        tileActions.get(mapHandler.getTile(player.getX(), player.getY() - 1)).run();
    }

    private void tryMoveRight() {
        tileActions.get(mapHandler.getTile(player.getX() + 1, player.getY())).run();
    }



    private void runNothing() {
    }

    private void runBlockage() {
    }

    private void runEnemy() {
    }

    private void runOutOfMap() {
    }



    public void printMe() {
        display.exploring(mapHandler.arrMap);
    }
}

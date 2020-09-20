package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.model.map.Coordinates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.bwebb.swingy.controller.GameController.*;
import static com.bwebb.swingy.model.map.MapHandler.*;

public class Exploring extends GameStateParent {
    private HashMap<String, Coordinates> keyCoordOffsets = new HashMap<String, Coordinates>();
    private static final Set<String> validKeys = new HashSet<String>(Arrays.asList("w", "a", "s", "d", "q"));

    @Override
    public boolean evaluate(String userInput) {
        return validKeys.contains(userInput);
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return ;
        }

        Coordinates offset = keyCoordOffsets.get(userInput);
        int targetTile = mapHandler.getTile(player.getPos().getX() + offset.getX(), player.getPos().getY() + offset.getY());

        switch (targetTile) {
            case -1 -> runEndOfMap();
            case 1 -> runEnemy();
            case 2 -> runBlockage();
            default -> runNothing(offset);
        }
    }

    public void runBlockage() {

    }

    public void runEndOfMap() {

    }

    public void runEnemy() {

    }

    public void runNothing(Coordinates offset) {
        movePlayer(offset);
        display.exploring(mapHandler.arrMap);
    }

    public void movePlayer(Coordinates offset) {
        mapHandler.setClearedTile(player.getPos());
        player.getPos().moveBy(offset);
        mapHandler.setPlayerPos(player.getPos());
    }

    public Exploring() {
        keyCoordOffsets.put("w", new Coordinates(0, 1));
        keyCoordOffsets.put("a", new Coordinates(-1, 0));
        keyCoordOffsets.put("s", new Coordinates(0, -1));
        keyCoordOffsets.put("d", new Coordinates(1, 0));
    }




    public void printMe() {
        display.exploring(mapHandler.arrMap);
    }
}

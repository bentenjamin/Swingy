package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;
import com.bwebb.swingy.model.map.Coordinates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Exploring extends GSTemplate {
    private final HashMap<String, Coordinates> keyCoordinateOffsets = new HashMap<>();
    private static final Set<String> validKeys = new HashSet<>(Arrays.asList("w", "a", "s", "d", "q", "i"));

    @Override
    public boolean evaluate(String userInput) {
        return validKeys.contains(userInput);
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return;
        }

        game.player.setOffSet(keyCoordinateOffsets.get(userInput));

        int targetX = game.player.getPos().getX() + game.player.getOffSet().getX();
        int targetY = game.player.getPos().getY() + game.player.getOffSet().getY();
        int targetTile = game.mapHandler.getTile(targetX, targetY);

        switch (targetTile) {
            case -1 -> runEndOfMap();
            case 1 -> runEnemy();
            case 2 -> runBlockage();
            default -> runNothing();
        }
    }

    public void runBlockage() {
        game.display.blockage();
    }

    public void runEndOfMap() {
        game.state = game.states.win;
    }

    public void runEnemy() {
        game.state = game.states.fight;
    }

    public void runNothing() {
        game.player.movePlayer(game.player.getOffSet(), game.mapHandler);
    }


    public Exploring(GameAssets game) {
        super(game);

        keyCoordinateOffsets.put("w", new Coordinates(0, 1));
        keyCoordinateOffsets.put("a", new Coordinates(-1, 0));
        keyCoordinateOffsets.put("s", new Coordinates(0, -1));
        keyCoordinateOffsets.put("d", new Coordinates(1, 0));
    }

    public void printMe() {
//        game.display.exploring(game.mapHandler.arrMap);
        game.display.exploring(game.mapHandler.arrMap, game.player.getPos());
    }
}

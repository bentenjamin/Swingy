package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;
import com.bwebb.swingy.model.map.Coordinates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class Exploring extends GSTemplate {
    private final HashMap<String, Coordinates> keyCoordinateOffsets = new HashMap<>();
    private Set<String> validKeys;

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
        game.viewController.display.blockage();
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

        commands.put("i", this::viewStats);


        //credit to https://stackoverflow.com/users/4556720/ytterrr
        //https://stackoverflow.com/questions/9062574/is-there-a-better-way-to-combine-two-string-sets-in-java
        validKeys = Stream.concat(commands.keySet().stream(), keyCoordinateOffsets.keySet().stream())
                .collect(Collectors.toSet());
    }

    @Override
    protected void listCommands() {
        game.viewController.display.listCommands(validKeys.toString());
    }

    public void printMe() {
        game.viewController.display.exploring(game.mapHandler.arrMap, game.player.getPos());
    }

    private void viewStats() {
        if (game.player != null)
            game.viewController.display.stats(game.player);
    }
}

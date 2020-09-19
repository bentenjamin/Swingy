package com.bwebb.swingy.controller;

import com.bwebb.swingy.controller.gameStates.EndScreen;
import com.bwebb.swingy.controller.gameStates.MainMenu;

import java.util.HashMap;

import static com.bwebb.swingy.controller.GameController.display;


public abstract class GameStateParent implements GameState {
    protected HashMap<String, Runnable> commands = new HashMap<>();
    protected GameState localGameState = null;

    public boolean evaluate(String userInput) {
        return (commands.get(userInput) != null);
    };

    public GameState execute(String userInput) {
        commands.get(userInput).run();
        return localGameState;
    }

    public GameStateParent() {
        commands.put("quit", this::quitGame);
    }

    private void quitGame() {
        display.endScreen();
        localGameState = null;
    }
}

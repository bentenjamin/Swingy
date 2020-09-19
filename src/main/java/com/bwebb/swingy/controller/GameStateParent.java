package com.bwebb.swingy.controller;

import java.util.HashMap;

import static com.bwebb.swingy.controller.GameController.currentState;
import static com.bwebb.swingy.controller.GameController.display;


public abstract class GameStateParent implements GameState {
    protected HashMap<String, Runnable> commands = new HashMap<>();

    public boolean evaluate(String userInput) {
        return (commands.get(userInput) != null);
    };

    public void execute(String userInput) {
        try {
            commands.get(userInput).run();
        } catch (NullPointerException e) {
            System.err.println("attempted to execute a command that doesnt exist: " + e);
        }
    }

    public GameStateParent() {
        commands.put("q", this::quitGame);
    }

    private void quitGame() {
        display.endScreen();
        currentState = null;
    }
}

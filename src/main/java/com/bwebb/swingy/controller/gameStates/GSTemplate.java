package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameAssets;

import java.util.HashMap;

public abstract class GSTemplate implements GameState {
    protected HashMap<String, Runnable> commands = new HashMap<>();
    protected GameAssets game = null;

    public boolean evaluate(String userInput) {
        return (commands.containsKey(userInput));
    };

    public void execute(String userInput) {
        try {
            commands.get(userInput).run();
        } catch (NullPointerException e) {
            System.err.println("attempted to execute a command that doesnt exist: " + e);
        }
    }

    public GSTemplate(GameAssets game) {
        this.game = game;

        commands.put("q", this::quitGame);
        commands.put("i", this::viewStats);
    }

    private void viewStats() {
        if (game.player != null)
            game.display.stats(game.player);
    }

    private void quitGame() {
        game.display.endScreen();
        game.state = null;
    }
}

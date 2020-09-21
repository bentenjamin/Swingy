package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameAssets;
import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Random;

public abstract class GSTemplate implements GameState {
    protected HashMap<String, Runnable> commands = new HashMap<>();
    protected GameAssets game = null;
    protected Faker faker = new Faker();
    protected Random random = new Random();

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

    public GSTemplate(GameAssets game) {
        this.game = game;

        commands.put("q", this::quitGame);
    }

    private void quitGame() {
        game.display.endScreen();
        game.state = null;
    }
}

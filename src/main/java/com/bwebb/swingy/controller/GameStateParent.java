package com.bwebb.swingy.controller;

import com.bwebb.swingy.controller.gameStates.EndScreen;
import com.bwebb.swingy.controller.gameStates.MainMenu;

import java.util.HashMap;


public abstract class GameStateParent {
    protected HashMap<String, Runnable> commands = new HashMap<>();
    protected GameState localGameState = null;

    public boolean evaluate(String userInput) {
        return (commands.get(userInput) != null);
    };
}

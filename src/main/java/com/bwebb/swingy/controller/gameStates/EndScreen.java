package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameState;

public class EndScreen implements GameState {

    @Override
    public boolean evaluate(String userInput) {
        return false;
    }

    @Override
    public GameState execute(String userInput) {
        return null;
    }
}

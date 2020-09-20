package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;

import static com.bwebb.swingy.controller.GameController.display;

public class LoadingPlayer extends GameStateParent {

    @Override
    public boolean evaluate(String userInput) {
        return super.evaluate(userInput);
    }

    @Override
    public void printMe() {
        display.loadingPlayer();
    }
}

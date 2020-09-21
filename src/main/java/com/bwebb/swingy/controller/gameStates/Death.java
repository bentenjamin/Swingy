package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;

import static com.bwebb.swingy.controller.GameController.display;

public class Death extends GameStateParent {
    @Override
    public void printMe() {
        display.death();
    }
}

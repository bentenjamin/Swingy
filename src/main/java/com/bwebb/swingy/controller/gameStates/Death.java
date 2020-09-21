package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;

import static com.bwebb.swingy.controller.GameController.*;

public class Death extends GameStateParent {
    @Override
    public void printMe() {
        display.death();
    }

    @Override
    public boolean evaluate(String userInput) {
        return true;
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput))
            commands.get(userInput).run();
        else
            currentState = gameStates.exploring;
    }
}

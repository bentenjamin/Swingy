package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.view.ViewInterface;
import static com.bwebb.swingy.controller.GameController.display;


public class EndScreen extends GameStateParent {

    @Override
    public boolean evaluate(String userInput) {
        return true;
    }

    @Override
    public GameState execute(String userInput) {
        display.endScreen();
        return null;
    }
}

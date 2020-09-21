package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.view.ViewInterface;

public interface GameState {
    boolean evaluate(String userInput);
    void execute(String userInput);
    void printMe();
}

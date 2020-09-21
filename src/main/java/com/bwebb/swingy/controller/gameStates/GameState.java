package com.bwebb.swingy.controller.gameStates;

public interface GameState {
    boolean evaluate(String userInput);
    void execute(String userInput);
    void printMe();
}

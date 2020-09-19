package com.bwebb.swingy.controller;

import com.bwebb.swingy.view.ViewInterface;

public interface GameState {
    boolean evaluate(String userInput);
    GameState execute(String userInput);
}

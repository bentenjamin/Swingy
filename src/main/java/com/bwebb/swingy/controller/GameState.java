package com.bwebb.swingy.controller;

public interface GameState {
    public boolean evaluate(String userInput);
    public GameState execute(String userInput);
}

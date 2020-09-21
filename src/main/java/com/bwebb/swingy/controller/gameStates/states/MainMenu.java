package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.gameStates.GameStateParent;

import static com.bwebb.swingy.controller.GameController.*;

public class MainMenu extends GameStateParent {
    public MainMenu() {
        commands.put("1", this::loadCreateCharacter);
        player = null;
    }

    private void loadCreateCharacter() {
        currentState = gameStates.charCreation;
    }

    public void printMe() {
        display.mainMenu();
    }
}

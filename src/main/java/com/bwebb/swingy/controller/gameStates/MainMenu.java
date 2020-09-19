package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.controller.GameStatesContainer;
import com.bwebb.swingy.view.ViewInterface;

import static com.bwebb.swingy.controller.GameController.*;

public class MainMenu extends GameStateParent {
    public MainMenu() {
        commands.put("1", this::loadCreateCharacter);
    }

    private void loadCreateCharacter() {
        currentState = gameStates.charCreation;
    }

    public void printMe() {
        display.mainMenu();
    }
}

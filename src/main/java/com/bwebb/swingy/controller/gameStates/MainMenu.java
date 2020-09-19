package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.view.ViewInterface;

import static com.bwebb.swingy.controller.GameController.display;

public class MainMenu extends GameStateParent {
    public MainMenu() {
        commands.put("1", this::loadCreateCharacter);
    }

    private void loadCreateCharacter() {
        display.createCharacter();
        localGameState = new CreateCharacter();
    }
}

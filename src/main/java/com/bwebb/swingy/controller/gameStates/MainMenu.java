package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.view.ViewInterface;

import static com.bwebb.swingy.controller.GameController.display;

public class MainMenu extends GameStateParent implements GameState {
    public MainMenu() {
        commands.put("1", this::loadCreateCharacter);
    }

    public void loadCreateCharacter() {
        display.createCharacter();
        localGameState = new CreateCharacter();
    }

    @Override
    public GameState execute(String userInput) {
        commands.get(userInput).run();
        return localGameState;
    }
}

package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

public class MainMenu extends GSTemplate {
    public MainMenu(GameAssets game) {
        super(game);

        commands.put("1", this::loadCreateCharacter);
        commands.put("2", this::loadSave);
        commands.put("3", this::deleteSave);
    }

    private void loadSave() {
        game.state = game.states.loadSave;
    }

    private void loadCreateCharacter() {
        game.state = game.states.charCreation;
    }

    public void printMe() {
        game.viewController.display.mainMenu();
    }

    public void deleteSave() {
        game.state = game.states.delete;
    }
}

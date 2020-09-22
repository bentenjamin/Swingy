package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

public class Save extends GSTemplate {

    public Save(GameAssets game) {
        super(game);

        commands.put("1", this::save);
        commands.put("2", () -> {});
    }

    @Override
    public void execute(String userInput) {
        super.execute(userInput);

        game.saveHandler.writeSaves();
        game.display.endScreen();
        game.state = null;
    }

    private void save() {
        game.saveHandler.savePlayer(game.player);
    }

    public void printMe() {
        game.display.askSave();
    }
}

package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

public class Save extends GSTemplate {

    public Save(GameAssets game) {
        super(game);

        commands.put("1", this::yesSave);
        commands.put("2", this::quit);
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return;
        }

        save();
    }

    private void save() {
        if (!game.saveHandler.saveExists(game.player))
            game.saveHandler.saveCharacter(game.player);
        game.saveHandler.writeSaves();
    }

    private void quit() {
        game.viewController.display.endScreen();
        game.state = null;
    }

    private void yesSave() {
        save();
        quit();
    }

    public void printMe() {
        game.viewController.display.askSave();
    }
}

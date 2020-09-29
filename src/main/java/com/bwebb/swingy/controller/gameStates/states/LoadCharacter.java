package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

public class LoadCharacter extends GSTemplate {

    public LoadCharacter(GameAssets game) {
        super(game);

        commands.put("b", this::back);
    }

    private void back() {
        game.state = game.states.menu;
    }

    @Override
    public boolean evaluate(String userInput) {
        return this.evaluateIntegerInput(userInput);
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return;
        }

        game.player = game.saveHandler.getSaveByIndex(Integer.parseInt(userInput) - 1);
        game.state = game.states.loadingPlayer;
        game.state.execute("big sad");
    }

    public void printMe() {
        game.viewController.display.loadPlayer(game.saveHandler.getSavedCharacterNames());
    }
}

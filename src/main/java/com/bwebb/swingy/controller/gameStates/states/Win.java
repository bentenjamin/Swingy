package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

public class Win extends GSTemplate {
    public Win(GameAssets game) {
        super(game);
    }

    @Override
    public void printMe() {
        game.display.win();
    }

    @Override
    public boolean evaluate(String userInput) {
        return true;
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput))
            commands.get(userInput).run();
        else {
            game.player.saveCharacter(game.display);
            game.state = game.states.menu;
        }
    }
}

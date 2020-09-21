package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

public class Death extends GSTemplate {
    public Death(GameAssets game) {
        super(game);
    }

    @Override
    public void printMe() {
        game.display.death();
    }

    @Override
    public boolean evaluate(String userInput) {
        return true;
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput))
            commands.get(userInput).run();
        else
            game.state = game.states.menu;
    }
}

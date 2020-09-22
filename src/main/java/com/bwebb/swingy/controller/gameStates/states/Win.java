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
            //set player pos to spawn so it wont crash when saved
            game.player.setPos(game.mapHandler.getSpawn(game.player.getLevel()));

            game.player = null;
            game.state = game.states.menu;
        }
    }
}

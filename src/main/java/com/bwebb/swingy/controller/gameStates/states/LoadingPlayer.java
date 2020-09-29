package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

public class LoadingPlayer extends GSTemplate {

    public LoadingPlayer(GameAssets game) {
        super(game);
    }

    @Override
    public void execute(String userInput) {
        this.printMe();
        initPlay();
        game.state = game.states.exploring;
    }

    private void initPlay() {
        game.mapHandler.genMap(game.player.getLevel());
        game.mapHandler.setPlayerPos(game.player.getPos());
    }

    @Override
    public void printMe() {
        game.viewController.display.loadingPlayer();
    }
}

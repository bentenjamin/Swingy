package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;
import com.bwebb.swingy.model.map.Coordinates;

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
        if (game.player.getPos().getX() == -1) {
            int defaultPlayerPos = (game.mapHandler.calcMapSize(game.player.getLevel()) / 2);
            game.player.setPos(new Coordinates(defaultPlayerPos, defaultPlayerPos));
        }
        game.mapHandler.setPlayerPos(game.player.getPos());
    }

    @Override
    public void printMe() {
        game.display.loadingPlayer();
    }
}

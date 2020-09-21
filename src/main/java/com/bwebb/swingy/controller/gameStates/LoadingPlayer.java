package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.model.map.Coordinates;

import static com.bwebb.swingy.controller.GameController.*;

public class LoadingPlayer extends GameStateParent {

    @Override
    public void execute(String userInput) {
        this.printMe();
        initPlay();
        currentState = gameStates.exploring;
    }

    private void initPlay() {
        mapHandler.genMap(player.getLevel());
        if (player.getPos().getX() == -1) {
            int defaultPlayerPos = (mapHandler.calcMapSize(player.getLevel()) / 2);
            player.setPos(new Coordinates(defaultPlayerPos, defaultPlayerPos));
        }
        mapHandler.setPlayerPos(player.getPos());
    }

    @Override
    public void printMe() {
        display.loadingPlayer();
    }
}

package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;

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
        if (player.getX() == -1) {
            int defaultPlayerPos = (mapHandler.calcMapSize(player.getLevel()) % 2) + 1;
            player.setX(defaultPlayerPos);
            player.setY(defaultPlayerPos);
        }
        mapHandler.setPlayerPos(player.getX(), player.getY());
    }

    @Override
    public void printMe() {
        display.loadingPlayer();
    }
}

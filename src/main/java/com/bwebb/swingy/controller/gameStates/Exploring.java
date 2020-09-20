package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.GameStateParent;

import static com.bwebb.swingy.controller.GameController.mapHandler;
import static com.bwebb.swingy.controller.GameController.player;

public class Exploring extends GameStateParent {

    public Exploring() {
        mapHandler.genMap(player.getLevel());
    }

    public void printMe() {

    }
}

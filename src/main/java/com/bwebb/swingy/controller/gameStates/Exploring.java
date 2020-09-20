package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.GameStateParent;

import static com.bwebb.swingy.controller.GameController.*;

public class Exploring extends GameStateParent {

    public Exploring() {
        commands.put("w", this::tryMoveUp);

    }

    private void tryMoveUp() {

    }



    public void printMe() {
        display.exploring(mapHandler.arrMap);
    }
}

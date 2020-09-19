package com.bwebb.swingy;

import com.bwebb.swingy.controller.GameController;
import com.bwebb.swingy.controller.views;

import java.io.IOException;

public class Swingy {
    public static void main(String[] args) throws IOException {
//        try {
//            views.valueOf(args[0]);
//        } catch(IllegalArgumentException e) {
//            System.exit(1);
//        }
        GameController game = new GameController(views.TERMINAL);
        game.startSwingy();
    }
    /* todo
        refactor classes again
        handle invalid view input
     */
}

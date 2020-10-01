package com.bwebb.swingy;

import com.bwebb.swingy.controller.GameController;
import com.bwebb.swingy.controller.views;

import java.io.IOException;

public class Swingy {
    public static void main(String[] args) throws IOException {
        try {
            views.valueOf(args[0].toUpperCase());
        } catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid view argument");
            System.exit(1);
        }
        GameController controller = new GameController();
        controller.startSwingy(views.valueOf(args[0].toUpperCase()));
    }
}

package com.bwebb.swingy.controller;

import com.bwebb.swingy.view.terminal.TerminalView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {
    public GameAssets game;

    public GameController() {
        game = new GameAssets(this);
    }

    @SuppressWarnings("SpellCheckingInspection")
    public void startSwingy(views argView) throws IOException {
        game.state = game.states.menu;
        game.viewController.setDisplay(argView);
    }

    public void runGuiCommand(String input) {
        game.state.execute(input);
        if (game.state != null)
            game.state.printMe();
        else
            game.viewController.getGuiView().dispose();
    }

    public void readConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (game.state != null && (game.viewController.display instanceof TerminalView)) {
            game.state.printMe();
            String line = "";

            try {
                line = br.readLine();
            } catch (IOException e) {
                game.viewController.display.invalidInput();
            }

            if (game.state.evaluate(line))
                game.state.execute(line);
            else
                game.viewController.display.invalidInput();
        }
    }

    public GameAssets getGame() {
        return game;
    }
}

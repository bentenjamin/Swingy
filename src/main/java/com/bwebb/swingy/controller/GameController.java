package com.bwebb.swingy.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {
    public GameAssets game = null;

    public GameController(views argView) {
        game = new GameAssets();

        switch (argView) {
            default -> game.display = game.terminalView;
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    public void startSwingy() throws IOException {
        game.state = game.states.menu;
        evaluateExecuteRepeat();
    }

    private void evaluateExecuteRepeat() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (game.state != null) {
            game.state.printMe();

            String line = br.readLine();
            if (game.state.evaluate(line))
                game.state.execute(line);
            else
                game.display.invalidInput();
        }
    }
}

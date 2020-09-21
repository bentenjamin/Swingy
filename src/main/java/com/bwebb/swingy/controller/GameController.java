package com.bwebb.swingy.controller;

import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.playerClass;
import com.bwebb.swingy.model.map.MapHandler;
import com.bwebb.swingy.view.ViewInterface;
import com.bwebb.swingy.view.terminal.TerminalView;
import com.github.javafaker.Faker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {
    public static GameStatesContainer gameStates = new GameStatesContainer();
    public static ViewInterface display = null ;
    public static GameState currentState = null;
    private TerminalView terminalView = new TerminalView();
    public static Character player = null;
    public static MapHandler mapHandler = new MapHandler(0);

    public GameController(views argView) {
        switch (argView) {
            default -> display = terminalView;
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    public void startSwingy() throws IOException {
        currentState = gameStates.menu;
        evaluateExecuteRepeat();
    }

    private void evaluateExecuteRepeat() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (currentState != null) {
            currentState.printMe();
            String line = br.readLine();
            if (currentState.evaluate(line))
                currentState.execute(line);
            else
                display.invalidInput();
        }
    }

}

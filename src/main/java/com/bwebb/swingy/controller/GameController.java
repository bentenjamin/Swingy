package com.bwebb.swingy.controller;

import com.bwebb.swingy.controller.gameStates.MainMenu;
import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.bwebb.swingy.model.map.MapHandler;
import com.bwebb.swingy.view.ViewInterface;
import com.bwebb.swingy.view.terminal.TerminalView;
import com.github.javafaker.Faker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

    public void startSwingy() throws IOException {
        currentState = gameStates.menu;
        currentState.printMe();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (currentState != null) {
            try {
                String line = br.readLine();
                if (currentState.evaluate(line)) {
                    currentState.execute(line);
                    if (currentState != null)
                        currentState.printMe();
                }
                else
                    display.invalidInput();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        MapHandler aMap = new MapHandler(0);
        display.exploring(aMap.arrMap);
//
    }

    private void evaluateExecuteRepeat() {

    }

    private void mainMenu() {
        int result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        display.mainMenu();
        try {
            result = Integer.parseInt(br.readLine());
            if (result == 1)
                display.hype();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void printRandomCharacter() {
        Faker faker = new Faker();
        ClassesBase myClass = new ClassesBase("fillerClass", 5, 5, 5);
        Character hero = new Character(faker.name().firstName(), myClass);
        System.out.println(hero.toString());
    }
}

package com.bwebb.swingy.controller;

import com.bwebb.swingy.controller.gameStates.EndScreen;
import com.bwebb.swingy.controller.gameStates.MainMenu;
import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.bwebb.swingy.model.chars.charClasses.classList.Warrior;
import com.bwebb.swingy.view.ViewInterface;
import com.bwebb.swingy.view.terminal.TerminalView;
import com.github.javafaker.Faker;

import javax.swing.text.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {
    private ViewInterface display;
    private TerminalView terminalView = new TerminalView();

    public GameController(views argView) {
        switch (argView) {
            default -> display = terminalView;
        }
    }

    public void startSwingy() throws IOException {
        GameState currentState = new MainMenu();
        display.mainMenu();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!(currentState instanceof EndScreen)) {
            try {
                String line = br.readLine();
                if (currentState.evaluate(line))
                    currentState = currentState.execute(line);
                else
                    display.invalidInput();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

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
        ClassesBase myClass = new Warrior();
        Character hero = new Character(faker.name().firstName(), myClass);
        System.out.println(hero.toString());
    }
}

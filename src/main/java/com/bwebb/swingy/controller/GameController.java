package com.bwebb.swingy.controller;

import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.bwebb.swingy.model.chars.charClasses.classList.Warrior;
import com.bwebb.swingy.view.viewController.ViewController;
import com.github.javafaker.Faker;

import javax.swing.text.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {
    ViewController display = new ViewController();

    public void startSwingy() {
        this.mainMenu();
    }

    private void mainMenu() {
        int result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        display.mainMenu(0);
        try {
            result = Integer.parseInt(br.readLine());
            if (result == 1)
                display.hype(0);
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

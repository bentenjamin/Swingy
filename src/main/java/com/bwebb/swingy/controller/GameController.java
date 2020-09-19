package com.bwebb.swingy.controller;

import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.bwebb.swingy.model.chars.charClasses.classList.Warrior;
import com.bwebb.swingy.view.viewController.ViewController;
import com.github.javafaker.Faker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class GameController {
    public static void startSwingy() {
        int result;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ViewController.mainMenu(0);
        try {
            result = Integer.parseInt(br.readLine());
            if (result == 1)
                ViewController.hype(0);
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

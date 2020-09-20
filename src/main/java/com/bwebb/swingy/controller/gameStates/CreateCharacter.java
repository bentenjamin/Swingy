package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.github.javafaker.Faker;

import static com.bwebb.swingy.controller.GameController.*;

public class CreateCharacter extends GameStateParent {
    Faker faker = new Faker();

    @Override
    public boolean evaluate(String userInput) {
        int selection;

        try {
            selection = Integer.parseInt(userInput);
        } catch (NullPointerException NumberFormatException) {
            return false;
        }
        if (selection < 1 || selection > 2)
            return false;

        return true;
    }

    @Override
    public void execute(String userInput) {
        try {
            player = new Character(faker.name().firstName(), new ClassesBase("warrior", 5, 5, 5));
        } catch (NullPointerException e) {
            System.err.println("attempted to execute a command that doesnt exist: " + e);
        }
    }

    public CreateCharacter() {
        commands.put("1", this::setPlayerWarrior);
        commands.put("2", this::setPlayerMage);
    }

    private void setPlayerWarrior() {
        player = new Character(faker.name().firstName(), new ClassesBase("warrior", 5, 5, 5));
//        currentState = gameStates
    }

    private void setPlayerMage() {
        player = new Character(faker.name().firstName(), new ClassesBase("mage", 5, 5, 5));
    }

    public void printMe() {
        display.createCharacter();
    }
}

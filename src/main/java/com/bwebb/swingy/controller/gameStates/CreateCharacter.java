package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.github.javafaker.Faker;

import static com.bwebb.swingy.controller.GameController.*;

public class CreateCharacter extends GameStateParent {
    Faker faker = new Faker();

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

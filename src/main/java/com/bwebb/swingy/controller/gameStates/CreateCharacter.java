package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.github.javafaker.Faker;

import static com.bwebb.swingy.controller.GameController.*;
import static com.bwebb.swingy.model.chars.charClasses.ClassesHandler.getClassObj;

public class CreateCharacter extends GameStateParent {
    Faker faker = new Faker();

    @Override
    public boolean evaluate(String userInput) {
        int selection;

        try {
            selection = Integer.parseInt(userInput);
        } catch (NullPointerException  e) {
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
        if (selection < 1 || selection > 2)
            return false;

        return true;
    }

    @Override
    public void execute(String userInput) {
        int classIndex = 0;
        try {
            classIndex = Integer.parseInt(userInput);
        } catch (NullPointerException  e) {
            System.out.println("no input: " + e);
        } catch (NumberFormatException e) {
            System.out.println("not an int: " + e);
        }
        player = createCharacter(classIndex);

        currentState = gameStates.loadingPlayer;
        currentState.execute("big sad");
    }

    private Character createCharacter(int classIndex) {
        Object[] classObj = getClassObj(classIndex);
        ClassesBase myClass = new ClassesBase((String) classObj[0], (int) classObj[1], (int) classObj[2], (int) classObj[3]);
        return new Character(faker.name().firstName(), myClass);
    }

    public void printMe() {
        display.createCharacter();
    }
}

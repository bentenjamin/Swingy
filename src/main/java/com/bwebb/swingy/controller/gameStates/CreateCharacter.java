package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.bwebb.swingy.model.chars.charClasses.ClassesHandler;
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
        if (selection < 1 || selection > ClassesHandler.getClassList().length)
            return false;

        return true;
    }

    @Override
    public void execute(String userInput) {
        int classIndex = (this.evaluate(userInput)) ? Integer.parseInt(userInput) : 0;
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

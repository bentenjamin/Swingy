package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;

import static com.bwebb.swingy.controller.GameController.display;
import static com.bwebb.swingy.model.chars.charClasses.characterClassesHandler.getClassesList;


public class CreateCharacter extends GameStateParent {

    public void printMe() {
        display.createCharacter(getClassesList());
    }
}

package com.bwebb.swingy.view.terminal;

import com.bwebb.swingy.view.ViewInterface;

public class TerminalView implements ViewInterface {
    public void mainMenu() {
        String mainMenu =
                "*~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                "|                         |\r\n" +
                "|        Swingy           |\r\n" +
                "|  i have a week to do    |\r\n" +
                "|      this fml           |\r\n" +
                "|                         |\r\n" +
                "|   1. Create Character   |\r\n" +
                "|   2. Choose Character   |\r\n" +
                "|                         |\r\n" +
                "*~~~~~~~~~~~~~~~~~~~~~~~~~*";

        System.out.println(mainMenu);
    }

    public void hype() {
        String hype = "HYPE";
        System.out.println(hype);
    }

    public void invalidInput() {
        String invalidInput = "That is not an option, please try again, or type quit to exit";
        System.out.println(invalidInput);
    }

    public void endScreen() {
        String endScreen= "Thank you for playing!";
        System.out.println(endScreen);
    }

    public void createCharacter() {
        String createCharacter =
                "*~~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                "|                          |\r\n" +
                "|     Create Character     |\r\n" +
                "|                          |\r\n" +
                "|                          |\r\n" +
                "|     idk didnt think id   |\r\n" +
                "|     get this far         |\r\n" +
                "|                          |\r\n" +
                "|                          |\r\n" +
                "*~~~~~~~~~~~~~~~~~~~~~~~~~~*";
        System.out.println(createCharacter);
    }

}
//    public void () {
//        String = "";
//        System.out.println();
//    }


// read input
// send input to current game state
// current game state evauluates
// state executes its code
// state decides next state
// state returns current state
// repeat
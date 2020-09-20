package com.bwebb.swingy.view.terminal;

import com.bwebb.swingy.model.chars.charClasses.ClassesHandler;
import com.bwebb.swingy.view.ViewInterface;

import java.util.Arrays;

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
        String endScreen = "Thank you for playing!";
        System.out.println(endScreen);
    }

    public void createCharacter() {
        String[] classList = ClassesHandler.getClassList();
        String createCharacter =

                "*~~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                "|                          |\r\n" +
                "|     Create Character     |\r\n" +
                "|                          |\r\n";


        for (int i = 0; i < classList.length; i++) {
            String line = "|  " + (i + 1) + ". " + classList[i];
            for (int j = 0; line.length() < 27; j++) {
                line += " ";
            }
            line += "|\r\n";
            createCharacter += line;
        }


        createCharacter +=
                "|                          |\r\n" +
                "*~~~~~~~~~~~~~~~~~~~~~~~~~~*";
        System.out.println(createCharacter);
    }

    public void generalPrint(String input) {
        System.out.println(input);
    }

    public void exploring(int[][] mapArr) {
        System.out.println(arrMapToStrMap(mapArr));
    }

    private String arrMapToStrMap(int[][] mapArr) {
        String strMap;
        int mapWidth = mapArr.length;
        int mapHeight = mapArr[0].length;
        int fillerSize = ((mapWidth + 1) * 2) + 1;
        String[] legend = {"$", "X", "O", "-"};

        strMap = filler(fillerSize, '~', '*');
        strMap += filler(fillerSize, ' ', '|');

        for (int y = mapHeight - 1; y >= 0; y--) {
            strMap += "|  ";
            for (int x = 0; x < mapWidth; x++) {
                strMap += legend[mapArr[x][y]] + ' ';
            }
            strMap += " |\r\n";
        }

        strMap += filler(fillerSize, ' ', '|');
        strMap += filler(fillerSize, '~', '*');

        return strMap;
    }

    private String filler(int length, char innerChar, char outerChar) {
        String filler = "" + outerChar;
        for (int i = 0; i < length; i++) {
            filler += innerChar;
        }
        filler += outerChar + "\r\n";
        return filler;
    }

    public void twoDArray(Object[][] arr) {
        System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
    }

    public void loadingPlayer() {
        System.out.println("Loading player...");
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

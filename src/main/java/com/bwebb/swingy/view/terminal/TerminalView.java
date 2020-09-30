package com.bwebb.swingy.view.terminal;

import com.bwebb.swingy.model.chars.charClasses.ClassesHandler;
import com.bwebb.swingy.model.chars.player.Character;
import com.bwebb.swingy.model.map.Coordinates;
import com.bwebb.swingy.view.DisplayStringHandler;
import com.bwebb.swingy.view.ViewInterface;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.Random;

public class TerminalView implements ViewInterface {
    private DisplayStringHandler strHandler;

    public TerminalView(DisplayStringHandler stringHandler) {
        strHandler = stringHandler;
    }

    public void mainMenu() {
        String mainMenu =
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                        "|                         |\r\n" +
                        "|        Swingy           |\r\n" +
                        "|  i have a week to do    |\r\n" +
                        "|      this fml           |\r\n" +
                        "|                         |\r\n" +
                        "|   1. Create Character   |\r\n" +
                        "|   2. Load Save          |\r\n" +
                        "|   3. Delete Save        |\r\n" +
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
                        "|                          |\r\n" +

                        makeViewFromArr(classList) +

                        "|                          |\r\n" +
                        "|     'b' to go back       |\r\n" +
                        "|                          |\r\n" +
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~~*";
        System.out.println(createCharacter);
    }

    public void generalPrint(String input) {
        System.out.println(input);
    }

    public void exploring(int[][] mapArr, Coordinates playerPos) {
        System.out.println(strHandler.arrMapToCenteredStrMap(mapArr, playerPos));
    }

    public void exploring(int[][] mapArr) {
        System.out.println(strHandler.arrMapToStrMap(mapArr));
    }

    public void twoDArray(Object[][] arr) {
        System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
    }

    public void loadingPlayer() {
        System.out.println("Loading player...");
    }

    @Override
    public void blockage() {
        Faker faker = new Faker();
        Random random = new Random();
        String monster = (random.nextBoolean()) ? faker.elderScrolls().creature() : faker.witcher().monster();
        System.out.println("A " + monster + " blocks your path!");
    }

    @Override
    public void artifactFound(String artifactType, int newArtifactStat, int currentArtifactStat) {
        String newArtifact =
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                        "|                         |\r\n" +
                        "|     Artifact Found!     |\r\n" +
                        "|                         |\r\n";

        String line = "|  Type: " + artifactType.toUpperCase();
        for (int j = 0; line.length() < 26; j++)
            line += " ";
        line += "|\r\n";
        newArtifact += line;

        line = "|  Current Buff: " + currentArtifactStat;
        for (int j = 0; line.length() < 26; j++)
            line += " ";
        line += "|\r\n";
        newArtifact += line;

        line = "|  Artifact Buff: " + newArtifactStat;
        for (int j = 0; line.length() < 26; j++)
            line += " ";
        line += "|\r\n";
        newArtifact += line +

                "|                         |\r\n" +
                "|  1. Equip               |\r\n" +
                "|  2. Drop                |\r\n" +
                "|                         |\r\n" +
                "*~~~~~~~~~~~~~~~~~~~~~~~~~*";

        System.out.println(newArtifact);
    }

    @Override
    public void enemyFound() {
        String fightOrFlee =
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                        "|                         |\r\n" +
                        "|   You have encountered  |\r\n" +
                        "|        an enemy!        |\r\n" +
                        "|                         |\r\n" +
                        "|   Do you Fight or       |\r\n" +
                        "|    attempt to Flee?     |\r\n" +
                        "|                         |\r\n" +
                        "|   1. FIGHT              |\r\n" +
                        "|   2. RUUUUUUUUNNNNNNN   |\r\n" +
                        "|                         |\r\n" +
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*";

        System.out.println(fightOrFlee);
    }

    public void fight() {
        System.out.println("You engage in BATTLE! Pain is temporary, GLORY IS FOREVER!");
    }

    public void fightWon() {
        System.out.println("You have triumphed over the heretic!");
    }

    public void fled() {
        System.out.println("Successfully evaded the enemy!");
    }

    @Override
    public void equippedArtifact() {
        System.out.println("Equipped your new loot :D");
    }

    @Override
    public void death() {
        String rip =
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                        "|                         |\r\n" +
                        "|      YOU HAVE DIED      |\r\n" +
                        "|                         |\r\n" +
                        "|                         |\r\n" +
                        "|                         |\r\n" +
                        "|                         |\r\n" +
                        "|                         |\r\n" +
                        "|    Press any key to     |\r\n" +
                        "|     return to the       |\r\n" +
                        "|      main menu...       |\r\n" +
                        "|                         |\r\n" +
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*";

        System.out.println(rip);
    }

    @Override
    public void levelUp(int playerLevel) {
        System.out.println("You have levelled up to Level " + playerLevel + "!");
    }

    @Override
    public void win() {
        String ftw =
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                        "|                         |\r\n" +
                        "|    MISSION COMPLETE     |\r\n" +
                        "|                         |\r\n" +
                        "|                         |\r\n" +
                        "|                         |\r\n" +
                        "|                         |\r\n" +
                        "|                         |\r\n" +
                        "|    Enter any key to     |\r\n" +
                        "|     return to the       |\r\n" +
                        "|      main menu...       |\r\n" +
                        "|                         |\r\n" +
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*";

        System.out.println(ftw);
    }

    public void stats(Character player) {
        String stats = "Name: " + player.getName() + "\r\n";
        stats += "Class: " + player.getPlayerClass().getClassName() + "\r\n";
        stats += "Attack: " + player.getPlayerClass().getAttack() + "\r\n";
        stats += "Defense: " + player.getPlayerClass().getDefense() + "\r\n";
        stats += "Health: " + player.getPlayerClass().getHealth() + "\r\n";
        stats += "Level: " + player.getLevel() + "\r\n";
        stats += "Exp: " + player.getLvl().getExperience() + "\r\n";
        stats += "Luck: " + player.getLuck();

        System.out.println(stats);
        player.getArtifacts().toString();
//        stats += ": " + player. + "\r\n";
    }

    @Override
    public void loadPlayer(String[] savedNamesList) {
        String saveList =

                        "*~~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                        "|                          |\r\n" +
                        "|      Load Character      |\r\n" +
                        "|                          |\r\n" +

                        makeViewFromArr(savedNamesList) +

                        "|                          |\r\n" +
                        "|    'b' to go back        |\r\n" +
                        "|                          |\r\n" +
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~~*";
        System.out.println(saveList);
    }

    @Override
    public void askSave() {
        String askSave =
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                        "|                         |\r\n" +
                        "|   Do you want to save?  |\r\n" +
                        "|                         |\r\n" +
                        "|   1. Yes                |\r\n" +
                        "|   2. No                 |\r\n" +
                        "|                         |\r\n" +
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~*";

        System.out.println(askSave);
    }

    @Override
    public void deleteSaves(String[] savesList) {
        String deleteSave =

                        "*~~~~~~~~~~~~~~~~~~~~~~~~~~*\r\n" +
                        "|                          |\r\n" +
                        "|     Delete Saves         |\r\n" +
                        "|                          |\r\n" +

                        makeViewFromArr(savesList) +

                        "|                          |\r\n" +
                        "|     'd' for all          |\r\n" +
                        "|    'b' to go back        |\r\n" +
                        "|                          |\r\n" +
                        "*~~~~~~~~~~~~~~~~~~~~~~~~~~*";
        System.out.println(deleteSave);
    }

    private String makeViewFromArr(String[] list) {
        String view = "";

        for (int i = 0; i < list.length; i++) {
            String line = "|  " + (i + 1) + ". " + list[i];
            for (int j = 0; line.length() < 27; j++) {
                line += " ";
            }
            line += "|\r\n";
            view += line;
        }

        return (view);
    }
}



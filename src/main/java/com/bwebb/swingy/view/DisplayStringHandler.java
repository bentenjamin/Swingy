package com.bwebb.swingy.view;

import com.bwebb.swingy.model.chars.player.Character;
import com.bwebb.swingy.model.map.Coordinates;
import com.github.javafaker.Faker;

import java.util.Random;

public class DisplayStringHandler {
    private final String[] legend = {"$", "X", "O", "-", "."};
    private final int viewSize = 13;


    public String arrMapToCenteredStrMap(int[][] mapArr, Coordinates playerPos) {
        String strMap = "";
        int midView = viewSize/2;
        int mapWidth = mapArr.length;
        int mapHeight = mapArr[0].length;
        int fillerSize = (viewSize * 2) + 1;

        strMap = filler(fillerSize,'-', '*');

        for (int y = viewSize - 1; y >= 0; y--) {
            strMap += "| ";
            for (int x = 0; x < viewSize; x++) {
                int mx = playerPos.getX() - midView + x;
                int my = playerPos.getY() - midView + y;
                if (((mx >= 0) && (mx < mapWidth)) && ((my >= 0) && (my < mapHeight)))
                    strMap += legend[mapArr[mx][my]];
                else
                    strMap += " ";
                strMap += " ";
            }
            strMap += "|\r\n";
        }
        strMap += filler(fillerSize,'-', '*');

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

    public String arrMapToStrMap(int[][] mapArr) {
        String strMap;
        int mapWidth = mapArr.length;
        int mapHeight = mapArr[0].length;
        int fillerSize = ((mapWidth + 1) * 2) + 1;

        strMap = filler(fillerSize, '~', '*');
        strMap += filler(fillerSize, ' ', '|');

        for (int y = mapHeight - 1; y >= 0; y--) {
            strMap += "|  ";
            for (int x = 0; x < mapWidth; x++)
                strMap += legend[mapArr[x][y]] + ' ';
            strMap += " |\r\n";
        }

        strMap += filler(fillerSize, ' ', '|');
        strMap += filler(fillerSize, '~', '*');

        return strMap;
    }

    public String genBlockage() {
        Faker faker = new Faker();
        Random random = new Random();
        String monster = (random.nextBoolean()) ? faker.elderScrolls().creature() : faker.witcher().monster();
        return ("A " + monster + " blocks your path!");
    }

    public String artifactString(String artifactType, int newArtifactStat, int currentArtifactStat) {
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

        return newArtifact;
    }

    public String formatStats(Character player) {
        String stats = "Name: " + player.getName() + "\r\n";
        stats += "Class: " + player.getPlayerClass().getClassName() + "\r\n";
        stats += "Attack: " + player.getPlayerClass().getAttack() + "\r\n";
        stats += "Defense: " + player.getPlayerClass().getDefense() + "\r\n";
        stats += "Health: " + player.getPlayerClass().getHealth() + "\r\n";
        stats += "Level: " + player.getLevel() + "\r\n";
        stats += "Exp: " + player.getLvl().getExperience() + "\r\n";
        stats += "Luck: " + player.getLuck() + "\r\n";
        stats += player.getArtifacts().toString();
        return stats;
    }
}

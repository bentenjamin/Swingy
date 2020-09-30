package com.bwebb.swingy.view;

import com.bwebb.swingy.model.map.Coordinates;

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
}

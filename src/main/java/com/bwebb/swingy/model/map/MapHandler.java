package com.bwebb.swingy.model.map;

import java.util.Arrays;
import java.util.Random;

public class MapHandler {
    public int[][] arrMap = null;

    public static final int mapNothing = 3, mapBlockage = 2, mapEnemy = 1, mapPlayer = 0, mapCleared = 4;

    public static int calcMapSize(int characterLevel) {
        return ((characterLevel - 1) * 5) + 10 - (characterLevel % 2);
    }

    public void genMap(int characterLevel) {
        int mapSize = calcMapSize(characterLevel);
        arrMap = new int[mapSize][mapSize];

        for (int[] arr : arrMap) {
            Arrays.fill(arr, mapNothing);
        }

        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                arrMap[x][y] = genTile();
            }
        }
    }

    private int genTile() {
        Random random = new Random();

        int i = random.nextInt(100);
        if (i < 60)
            return mapNothing;
        if (i < 80)
            return mapBlockage;
        return mapEnemy;
    }

    public void setPlayerPos(Coordinates coords) {
        if (arrMap != null) {
            arrMap[coords.getX()][coords.getY()] = mapPlayer;
        }
    }

    public int getTile(int x, int y) {
        if (x < 0 || x > arrMap.length - 1 || y < 0 || y > arrMap.length - 1)
            return -1;
        return arrMap[x][y];
    }

    public void setClearedTile(Coordinates coords) {
        arrMap[coords.getX()][coords.getY()] = mapCleared;
    }

    public Coordinates getSpawn(int playerLevel) {
        int spawnCoords = (calcMapSize(playerLevel) / 2);
        return new Coordinates(spawnCoords, spawnCoords);
    }
}

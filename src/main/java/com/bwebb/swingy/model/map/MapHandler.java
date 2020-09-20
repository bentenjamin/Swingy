package com.bwebb.swingy.model.map;

import java.util.Arrays;
import java.util.Random;

public class MapHandler {
    public int[][] arrMap = null;

    private final int nothing = 3, blockage = 2, enemy = 1, player = 0;

    public MapHandler(int characterLevel) {
        genMap(characterLevel);
    }

    public int calcMapSize(int characterLevel) {
        return ((characterLevel - 1) * 5) + 10 - (characterLevel % 2);
    }

    public void genMap(int characterLevel) {
        int mapSize = calcMapSize(characterLevel);
        arrMap = new int[mapSize][mapSize];

        for (int[] arr: arrMap) {
            Arrays.fill(arr, nothing);
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
            return nothing;
        if (i < 80)
            return blockage;
        return enemy;
    }

    public void setPlayerPos(int x, int y) {
        if (arrMap != null) {
            arrMap[x][y] = player;
        }
    }
}

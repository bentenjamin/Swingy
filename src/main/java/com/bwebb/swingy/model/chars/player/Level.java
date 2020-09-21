package com.bwebb.swingy.model.chars.player;

import static com.bwebb.swingy.controller.GameController.display;
import static java.lang.Math.pow;

public class Level {
    private int level = 1, experience = 0;

    public void addExp(int exp) {
        experience += exp;
        checkExp();
    }

    public void checkExp() {
        int levelExp = levelUpThreshold(level);
        if (levelExp < experience)
            levelUp(experience - levelExp);
    }

    public void levelUp(int remainderExp) {
        level += 1;
        experience = remainderExp;
        display.levelUp(level);
    }

    public static int levelUpThreshold(int playerLevel) {
        return (int) ((playerLevel * 1000) + (pow((playerLevel - 1), 2) * 450));
    }

    public int getLevel() {
        return level;
    }
}

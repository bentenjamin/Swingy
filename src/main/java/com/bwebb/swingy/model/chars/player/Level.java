package com.bwebb.swingy.model.chars.player;

import com.bwebb.swingy.view.ViewInterface;

import static java.lang.Math.pow;

public class Level {
    private int level, experience;

    public Level(int level, int exp) {
        this.level = level;
        this.experience = exp;
    }

    public Level() {
        this.level = 1;
        this.experience = 0;
    }

    public void addExp(int exp, ViewInterface display) {
        experience += exp;
        checkExp(display);
    }

    public void checkExp(ViewInterface display) {
        int levelExp = levelUpThreshold(level);
        if (levelExp < experience)
            levelUp(experience - levelExp, display);
    }

    public void levelUp(int remainderExp, ViewInterface display) {
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

    public int getExperience() {
        return experience;
    }
}

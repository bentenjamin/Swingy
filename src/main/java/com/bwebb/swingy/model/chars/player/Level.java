package com.bwebb.swingy.model.chars.player;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import static java.lang.Math.pow;

public class Level {
    @Positive
    private int  level;

    @PositiveOrZero
    private int  experience;

    public Level(int level, int exp) {
        this.level = level;
        this.experience = exp;
    }

    public Level() {
        this.level = 1;
        this.experience = 0;
    }

    public boolean addExp(int exp) {
        experience += exp;
        return checkExp();
    }

    public boolean checkExp() {
        int levelExp = levelUpThreshold(level);

        if (levelExp < experience) {
            levelUp(experience - levelExp);
            return true;
        }
        return false;
    }

    public void levelUp(int remainderExp) {
        level += 1;
        experience = remainderExp;
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

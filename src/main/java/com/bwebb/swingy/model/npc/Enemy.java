package com.bwebb.swingy.model.npc;

import static com.bwebb.swingy.model.chars.player.Level.levelUpThreshold;
import static java.lang.Math.pow;

public class Enemy {
    private final int attack, defense, health;

    /* general equation used:
        a + b * (c / d)^e
        a = base health
        b = 'target' health
        c = player level
        d = level at which you will hit b
        e = how big the difference between levels will be
     */
    public Enemy(int playerLevel) {
        final int  baseHealth = 10, baseDefense = 5, baseAttack = 10;

        health = (int) (baseHealth + (300 * pow((int) ((float)playerLevel / 5), 2)));
        defense = (int) (baseDefense + (300 * pow((int) ((float)playerLevel / 5), 2)));
        attack = (int) (baseAttack + (300 * pow(((float)playerLevel / 5), 2)));
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public int getExp(int playerLevel) {
        int xp = levelUpThreshold(playerLevel) * 15 / 100;
        xp += this.attack;
        return xp;
    }
}

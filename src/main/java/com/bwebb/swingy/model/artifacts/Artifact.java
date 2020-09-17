package com.bwebb.swingy.model.artifacts;

import com.github.javafaker.Faker;

import java.util.Random;
import static java.lang.Math;

public abstract class Artifact {
    //needs to be adjusted depending on the balance of the player stats
    private final static int characterStatBoostBase = 3;
    private final static int characterStatBoostRange = 3;

    private String type = "defaultType";
    private String name = "defaultName";
    private String statModifier = "defaultStatModifier";
    private int statBoost = 0;

    //should be updated with new artifacts, generally just for debugging
    private static final String[] types = {"weapon", "armour", "helm"};
    private static final String[] characterStats = {"attack", "defense", "health"};

    public Artifact(int type, int characterLuck) {
        Faker faker = new Faker();

        this.type = types[type];
        this.statModifier = characterStats[type];
        this.statBoost = calcStatBoost(characterLuck);
        this.name = faker.name().fullName();

    }

    private int calcStatBoost(int characterLuck) {
        Random random = new Random();
        return characterStatBoostBase +
                random.nextInt(characterStatBoostRange + 1) +
                (int) Math.ceil(luck / 30);
    }

    public int getStatBoost() {
        return statBoost;
    }
}

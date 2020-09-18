package com.bwebb.swingy.model.artifacts;

import com.github.javafaker.Faker;

import static com.bwebb.swingy.model.helper.MathFunctions.rand_gaus;

public abstract class Artifact {
    //needs to be adjusted depending on the balance of the player stats
    private final static int characterStatBoostBase = 3;
    private final static int characterStatBoostRange = 3;

    private String type = "fillerType";
    private String name = "fillerName";
    private String statModifier = "fillerStatModifier";
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
        double skew = 1.7 - ((double) characterLuck / 100);
        int statBoost = rand_gaus(0, characterStatBoostRange, skew);

        return characterStatBoostBase + statBoost;
    }

    public int getStatBoost() {
        return statBoost;
    }
}

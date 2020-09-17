package com.bwebb.swingy.model.artifacts;

public abstract class Artifact {
    //needs to be ajusted depending on the balance of the player stats
    private final static int characterStatBoostBase = 5;
    private final static int characterStatBoostRange = 5;

    private String type = "defaultType";
    private String name = "defaultName";
    private String statModifier = "defaultStatModifier";
    private int statBoost = 0;

    //should be updated with new artifacts, generally just for debugging
    private static final String[] types = {"weapon", "armour", "helm"};
    private static final String[] characterStats = {"attack", "defense", "health"};

    public Artifact(int type, int luck) {
        this.type = types[type];
        this.statModifier = characterStats[type];

        this.statBoost
    }

    public int getStatBoost() {
        return statBoost;
    }
}

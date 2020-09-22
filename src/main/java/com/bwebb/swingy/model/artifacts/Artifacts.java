package com.bwebb.swingy.model.artifacts;

import static com.bwebb.swingy.model.helper.MathFunctions.rand_gaus;

public class Artifacts {
    private Object[][] artifacts = {
            {"weapon", 0},
            {"armour", 0},
            {"helm", 0}
    };

    private final static int artifactBaseStat = 25;
    private final static int artifactStatRange = 25;

    public Artifacts(int weapon, int armour, int helm) {
        setWeapon(weapon);
        setArmour(armour);
        setHelm(helm);
    }

    public Artifacts() {
    }


    public String[] getArtifactList() {
        String[] artifactList = new String[artifacts.length];
        for (int i = 0; i < artifacts.length; i++) {
            artifactList[i] = (String) artifacts[i][0];
        }
        return artifactList;
    }

    public int getWeapon() {
        return (int) artifacts[0][1];
    }

    public int getArmour() {
        return (int) artifacts[1][1];
    }

    public int getHelm() {
        return (int) artifacts[2][1];
    }

    public void setWeapon(int artifactStat) {
        artifacts[0][1] = artifactStat;
    }

    public void setArmour(int artifactStat) {
        artifacts[1][1] = artifactStat;
    }

    public void setHelm(int artifactStat) {
        artifacts[2][1] = artifactStat;
    }

    public int getArtifactByIndex(int index) {
        if (index < 0 || index >= artifacts.length)
            return 0;
        return (int) artifacts[index][1];
    }

    public void setArtifactByIndex(int index, int artifactStat) {
        if (index < 0 || index >= artifacts.length)
            return;
        artifacts[index][1] = artifactStat;
    }

    public int calcStatBoost(int characterLuck) {
        double skew = 1.7 - ((double) characterLuck / 100);
        int statBoost = rand_gaus(0, artifactStatRange, skew);

        return artifactBaseStat + statBoost;
    }

    public Object[][] getArtifacts() {
        return artifacts;
    }
}

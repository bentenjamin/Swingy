package com.bwebb.swingy.model.artifacts;

import javax.validation.Valid;

import java.util.Arrays;

import static com.bwebb.swingy.model.helper.MathFunctions.rand_gaus;

public class Artifacts {
    private @Valid
    final Artifact[] artifacts = {
            new @Valid Artifact("weapon", 0),
            new @Valid Artifact("armour", 0),
            new @Valid Artifact("helm", 0)
    };

    public final static int artifactBaseStat = 25;
    public final static int artifactStatRange = 25;

    public Artifacts(int weapon, int armour, int helm) {
        setWeapon(weapon);
        setArmour(armour);
        setHelm(helm);
    }

    public Artifacts() {}

    public String[] getArtifactList() {
        String[] artifactList = new String[artifacts.length];
        for (int i = 0; i < artifacts.length; i++) {
            artifactList[i] = artifacts[i].type;
        }
        return artifactList;
    }

    public int getWeapon() {
        return artifacts[0].buff;
    }

    public int getArmour() {
        return artifacts[1].buff;
    }

    public int getHelm() {
        return artifacts[2].buff;
    }

    public void setWeapon(int artifactStat) {
        artifacts[0].buff = artifactStat;
    }

    public void setArmour(int artifactStat) {
        artifacts[1].buff = artifactStat;
    }

    public void setHelm(int artifactStat) {
        artifacts[2].buff = artifactStat;
    }

    public int getArtifactByIndex(int index) {
        if (index < 0 || index >= artifacts.length)
            return 0;
        return artifacts[index].buff;
    }

    public void setArtifactByIndex(int index, int artifactStat) {
        if (index < 0 || index >= artifacts.length)
            return;
        artifacts[index].buff = artifactStat;
    }

    public int calcStatBoost(int characterLuck) {
        double skew = 1.7 - ((double) characterLuck / 100);
        int statBoost = rand_gaus(0, artifactStatRange, skew);

        return artifactBaseStat + statBoost;
    }

    @Override
    public String toString() {
        String artifactString = "Artifacts:\n";

        for (Artifact artifact: artifacts)
            artifactString += artifact.toString();

        return artifactString;
    }
}

/*todo
*  tostring*/

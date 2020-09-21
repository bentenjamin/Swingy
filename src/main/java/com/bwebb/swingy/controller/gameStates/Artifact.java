package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;

import java.util.Random;

import static com.bwebb.swingy.controller.GameController.*;

public class Artifact extends GameStateParent {
    private int findChance = 30, findRange = 20;
    Random random = new Random();
    private int artifactIndex;
    private int artifactStat;

    public Artifact() {
        commands.put("1", this::pickUp);
        commands.put("2", this::leave);
    }

    private void pickUp() {
        player.artifacts.setArtifactByIndex(artifactIndex, artifactStat);
        display.equipedArtifact;
        leave();
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return;
        }

        int luckModifier = (int) findRange * player.getLuck() / 100;
        if (random.nextInt(100) > findChance + luckModifier)
            leave();
        else
            genArtifact();
    }

    public void genArtifact() {
        artifactIndex = random.nextInt(3);
        artifactStat = player.artifacts.calcStatBoost(player.getLuck());
    }

    public void leave() {
        mapHandler.movePlayer(player.getOffSet());
        currentState = gameStates.exploring;
    }

    @Override
    public void printMe() {
        display.artifactFound(gib me stats);
    }
}

package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

import java.util.Random;

public class Artifact extends GSTemplate {
    private int findChance = 30, findRange = 20;
    private int artifactIndex;
    private int artifactStat;

    public Artifact(GameAssets game) {
        super(game);
        commands.put("1", this::pickUp);
        commands.put("2", this::leave);
    }

    private void pickUp() {
        game.player.artifacts.setArtifactByIndex(artifactIndex, artifactStat);
        game.display.equippedArtifact();
        leave();
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return;
        }

        int luckModifier = findRange * game.player.getLuck() / 100;
        if (random.nextInt(101) > findChance + luckModifier)
            leave();
        else
            genArtifact();
    }

    public void genArtifact() {
        artifactIndex = random.nextInt(3);
        artifactStat = game.player.artifacts.calcStatBoost(game.player.getLuck());
    }

    public void leave() {
        game.player.movePlayer(game.player.getOffSet(), game.mapHandler);
        game.state = game.states.exploring;
    }

    @Override
    public void printMe() {
        game.display.artifactFound(game.player.artifacts.getArtifactList()[artifactIndex], artifactStat, game.player.artifacts.getArtifactByIndex(artifactIndex));
    }
}

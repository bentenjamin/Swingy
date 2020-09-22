package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

public class Artifact extends GSTemplate {
    private int artifactIndex;
    private int artifactStat;

    public Artifact(GameAssets game) {
        super(game);
        commands.put("1", this::pickUp);
        commands.put("2", this::leave);
    }

    private void pickUp() {
        game.player.getArtifacts().setArtifactByIndex(artifactIndex, artifactStat);
        game.display.equippedArtifact();
        leave();
    }

    @Override
    public void execute(String userInput) {
        final int findChance = 30, findRange = 20;

        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return;
        }

        int luckModifier = findRange * game.player.getLuck() / 100;
        if (game.random.nextInt(101) > findChance + luckModifier)
            leave();
        else
            genArtifact();
    }

    public void genArtifact() {
        artifactIndex = game.random.nextInt(3);
        artifactStat = game.player.getArtifacts().calcStatBoost(game.player.getLuck());
    }

    public void leave() {
        game.player.movePlayer(game.player.getOffSet(), game.mapHandler);
        game.state = game.states.exploring;
    }

    @Override
    public void printMe() {
        game.display.artifactFound(game.player.getArtifacts().getArtifactList()[artifactIndex], artifactStat, game.player.getArtifacts().getArtifactByIndex(artifactIndex));
    }
}

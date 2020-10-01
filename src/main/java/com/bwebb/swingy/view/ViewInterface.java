package com.bwebb.swingy.view;

import com.bwebb.swingy.model.chars.player.Character;
import com.bwebb.swingy.model.map.Coordinates;

public interface ViewInterface {
    void mainMenu();

    void invalidInput();

    void endScreen();

    void createCharacter();

    void exploring(int[][] curMap, Coordinates playerPos);

    void loadingPlayer();

    void blockage();

    void artifactFound(String artifactType, int newArtifactStat, int currentArtifactStat);

    void enemyFound();

    void fight();

    void fightWon();

    void fled();

    void equippedArtifact();

    void death();

    void levelUp(int playerLevel);

    void win();

    void stats(Character player);

    void loadPlayer(String[] savedNamesList);

    void askSave();

    void deleteSaves(String[] savesList);

    void listCommands(String commands);
}

/*todo
*  instructions for moving*/

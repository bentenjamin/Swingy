package com.bwebb.swingy.view;

public interface ViewInterface {
    void mainMenu();
    void hype();
    void invalidInput();
    void endScreen();
    void createCharacter();
    void generalPrint(String input);
    void exploring(int[][] curMap);
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
}

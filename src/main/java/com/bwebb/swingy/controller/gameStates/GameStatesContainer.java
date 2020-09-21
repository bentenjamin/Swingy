package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.gameStates.states.*;

public class GameStatesContainer {
    public GameState menu = new MainMenu();
    public GameState charCreation = new CreateCharacter();
    public GameState loadingPlayer = new LoadingPlayer();
    public GameState exploring = new Exploring();
    public GameState artifact = new Artifact();
    public GameState fight = new Fight();
    public GameState death = new Death();
    public GameState win = new Win();
}

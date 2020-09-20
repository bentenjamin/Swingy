package com.bwebb.swingy.controller;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.gameStates.CreateCharacter;
import com.bwebb.swingy.controller.gameStates.Exploring;
import com.bwebb.swingy.controller.gameStates.LoadingPlayer;
import com.bwebb.swingy.controller.gameStates.MainMenu;

public class GameStatesContainer {
    public GameState menu = new MainMenu();
    public GameState charCreation = new CreateCharacter();
    public GameState loadingPlayer = new LoadingPlayer();
    public GameState exploring = new Exploring();
}

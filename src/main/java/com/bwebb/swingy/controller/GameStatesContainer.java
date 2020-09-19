package com.bwebb.swingy.controller;

import com.bwebb.swingy.controller.GameState;
import com.bwebb.swingy.controller.gameStates.CreateCharacter;
import com.bwebb.swingy.controller.gameStates.MainMenu;

public class GameStatesContainer {
    public GameState menu = new MainMenu();
    public GameState charCreation = new CreateCharacter();
}

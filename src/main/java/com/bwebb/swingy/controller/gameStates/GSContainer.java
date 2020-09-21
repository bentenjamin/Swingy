package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.states.*;

public class GSContainer {
    public GameState menu = null;
    public GameState charCreation = null;
    public GameState loadingPlayer = null;
    public GameState exploring = null;
    public GameState artifact = null;
    public GameState fight = null;
    public GameState death = null;
    public GameState win = null;

    public GSContainer(GameAssets game) {
        menu = new MainMenu(game);
        charCreation = new CreateCharacter(game);
        loadingPlayer = new LoadingPlayer(game);
        exploring = new Exploring(game);
        artifact = new Artifact(game);
        fight = new Fight(game);
        death = new Death(game);
        win = new Win(game);
    }
}

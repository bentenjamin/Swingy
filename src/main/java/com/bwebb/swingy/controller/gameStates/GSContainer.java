package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.states.*;

public class GSContainer {
    public GameState menu;
    public GameState charCreation;
    public GameState loadingPlayer;
    public GameState exploring;
    public GameState artifact;
    public GameState fight;
    public GameState death;
    public GameState win;
    public GameState loadSave;
    public GameState save;
    public GameState delete;

    public GSContainer(GameAssets game) {
        menu = new MainMenu(game);
        charCreation = new CreateCharacter(game);
        loadingPlayer = new LoadingPlayer(game);
        exploring = new Exploring(game);
        artifact = new Artifact(game);
        fight = new Fight(game);
        death = new Death(game);
        win = new Win(game);
        save = new Save(game);
        loadSave = new LoadCharacter(game);
        delete = new deleteSaves(game);
    }
}

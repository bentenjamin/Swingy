package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;
import com.bwebb.swingy.model.chars.charClasses.ClassesHandler;
import com.bwebb.swingy.model.chars.charClasses.PlayerClass;
import com.bwebb.swingy.model.chars.player.Character;

public class LoadCharacter extends GSTemplate {

    public LoadCharacter(GameAssets game) {
        super(game);

        commands.put("b", this::back);
    }

    private void back() {
        game.state = game.states.menu;
    }

    @Override
    public boolean evaluate(String userInput) {
        int selection;

        if (commands.containsKey(userInput))
            return true;

        if (game.saveHandler.countSaves() == 0)
            return false;

        try {
            selection = Integer.parseInt(userInput);
        } catch (NullPointerException  e) {
            return false;
        } catch (NumberFormatException e) {
            return false;
        }

        if (selection >= 1 && selection <= game.saveHandler.countSaves())
            return true;

        return false;
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return ;
        }
        game.player = game.saveHandler.loadCharacterFromArr(game.saveHandler.getSaveByIndex(Integer.parseInt(userInput) - 1));

        game.state = game.states.loadingPlayer;
        game.state.execute("big sad");
    }

    public void printMe() {
        game.display.loadPlayer(game.saveHandler.getSavedCharacterNames());
    }
}

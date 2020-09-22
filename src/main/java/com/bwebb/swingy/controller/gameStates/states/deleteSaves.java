package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;

public class deleteSaves extends GSTemplate {

    public deleteSaves(GameAssets game) {
        super(game);

        commands.put("b", this::back);
        commands.put("d", this::purge);
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

    public void execute(String userInput) {
        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return ;
        }

        game.saveHandler.deleteSaveByIndex(Integer.parseInt(userInput) - 1);
    }

    private void purge() {
        game.saveHandler.purgeCharacters();
        game.saveHandler.writeSaves();
    }

    public void printMe() {
        game.display.deleteSaves(game.saveHandler.getSavedCharacterNames());
    }
}

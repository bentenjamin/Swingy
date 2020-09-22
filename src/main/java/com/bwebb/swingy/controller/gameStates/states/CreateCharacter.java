package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;
import com.bwebb.swingy.model.chars.charClasses.ClassesHandler;
import com.bwebb.swingy.model.chars.charClasses.PlayerClass;
import com.bwebb.swingy.model.chars.player.Character;

public class CreateCharacter extends GSTemplate {

    public CreateCharacter(GameAssets game) {
        super(game);
        commands.put("b", this::back);
    }

    @Override
    public boolean evaluate(String userInput) {
        int selection;

        if (commands.containsKey(userInput))
            return true;

        try {
            selection = Integer.parseInt(userInput);
        } catch (NullPointerException e) {
            return false;
        } catch (NumberFormatException e) {
            return false;
        }

        if (selection >= 1 && selection <= ClassesHandler.getClassList().length)
            return true;

        return false;
    }

    @Override
    public void execute(String userInput) {
        if (commands.containsKey(userInput)) {
            commands.get(userInput).run();
            return;
        }
        int classIndex = (this.evaluate(userInput)) ? (Integer.parseInt(userInput) - 1) : 0;
        game.player = createCharacter(classIndex);
        game.player.setPos(game.mapHandler.getSpawn(game.player.getLevel()));
        game.state = game.states.save;
        game.state.execute("save");

        game.state = game.states.loadingPlayer;
        game.state.execute("big sad");
    }

    private Character createCharacter(int classIndex) {
        PlayerClass myClass = new PlayerClass(classIndex);
        return new Character(game.faker.name().firstName(), myClass);
    }

    public void printMe() {
        game.display.createCharacter();
    }

    private void back() {
        game.state = game.states.menu;
    }
}

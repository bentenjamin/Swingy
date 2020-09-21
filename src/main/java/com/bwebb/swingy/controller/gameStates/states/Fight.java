package com.bwebb.swingy.controller.gameStates.states;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.gameStates.GSTemplate;
import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.npc.Enemy;

import java.util.Random;


public class Fight extends GSTemplate {

    public Fight(GameAssets game) {
        super(game);

        commands.put("1", this::fightEnemy);
        commands.put("2", this::flee);
    }

    private void fightEnemy() {
        game.display.fight();
        Enemy enemy = new Enemy(game.player.getLevel());
        if (rumble(game.player, enemy))
            fightWon(enemy.getExp(game.player.getLevel()));
        else
            game.state = game.states.death;
    }

    private void fightWon(int enemyExp) {
        game.display.fightWon();
        game.player.getLvl().addExp(enemyExp, game.display);
        game.state = game.states.artifact;
        game.state.execute("");
    }

    private void flee() {
        if (game.random.nextBoolean()) {
            game.display.fled();
            game.state = game.states.exploring;
        } else
            fightEnemy();
    }

    private boolean rumble(Character player, Enemy badGuy) {
        int playerEHP, enemyEHP;

        playerEHP = player.getEffectiveHealth() + player.getEffectiveDefense();
        enemyEHP = badGuy.getHealth() + badGuy.getDefense();

        return (playerEHP / badGuy.getAttack() > enemyEHP / player.getEffectiveAttack());
    }

    @Override
    public void printMe() {
        game.display.enemyFound();
    }
}

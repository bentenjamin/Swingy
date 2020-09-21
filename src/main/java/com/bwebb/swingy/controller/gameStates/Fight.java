package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.npc.Enemy;

import java.util.Random;

import static com.bwebb.swingy.controller.GameController.*;


public class Fight extends GameStateParent {
    private Random random = new Random();

    public Fight() {
        commands.put("1", this::fightEnemy);
        commands.put("2", this::flee);
    }

    private void fightEnemy() {
        display.fight();
        Enemy enemy = new Enemy(player.getLevel());
        if (rumble(player, enemy))
            fightWon(enemy.getExp(player.getLevel()));
        else
            currentState = gameStates.death();
    }

    private void fightWon(int enemyExp) {
        display.fightWon();
        player.getLvl().addExp(enemyExp);
        currentState = gameStates.artifact;
        currentState.execute("");
    }

    private void flee() {
        if (random.nextBoolean()) {
            display.flead();
            currentState = gameStates.exploring;
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
        display.enemyFound()
    }
}

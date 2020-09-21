package com.bwebb.swingy.controller.gameStates;

import com.bwebb.swingy.controller.GameStateParent;
import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.npc.Enemy;

import static com.bwebb.swingy.controller.GameController.*;


public class Fight extends GameStateParent {

    public Fight() {
        commands.put("1", this::fightEnemy);
        commands.put("2", this::flee);
    }

    private void fightEnemy() {
        Enemy enemy = new Enemy(player.getLevel());
        if (rumble(player, enemy)) {
            player.addExp(enemy.getExp(player.getLevel()));

        }
    }

    private boolean rumble(Character player, Enemy badGuy) {
        int playerEHP, enemyEHP;

        playerEHP = player.getEffectiveHealth() + player.getEffectiveDefense();
        enemyEHP = badGuy.getHealth() + badGuy.getDefense();

        return (playerEHP/ badGuy.getAttack() > enemyEHP/player.getEffectiveAttack());
    }

    @Override
    public void printMe() {

    }
}

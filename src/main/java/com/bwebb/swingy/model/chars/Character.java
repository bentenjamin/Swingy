package com.bwebb.swingy.model.chars;

import com.bwebb.swingy.model.artifacts.Artifacts;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.bwebb.swingy.model.chars.player.Level;
import com.bwebb.swingy.model.map.Coordinates;

import static com.bwebb.swingy.model.helper.MathFunctions.rand_gaus;

public class Character {
    private String name = "defaultName";
    private ClassesBase playerClass = null;
    private Coordinates pos = null;
    private int luck = 0;
    public Artifacts artifacts = null;
    private Level lvl = null;

    //artifacts

    public Character(String name, ClassesBase playerClass) {
        this.name = name;
        this.playerClass = playerClass;
        this.pos = new Coordinates(-1,-1);
        this.artifacts = new Artifacts();
        this.lvl = new Level();

        //luck is random between 0-100 and has a bias to lower ranges (0-40~)
        this.luck = rand_gaus(0, 100);
    }

    public int getEffectiveAttack() {
        return this.playerClass.getAttack() + artifacts.getWeapon();
    }

    public int getEffectiveDefense() {
        return this.playerClass.getDefense() + artifacts.getArmour();
    }

    public int getEffectiveHealth() {
        return this.playerClass.getHealth() + artifacts.getHelm();
    }

    public int getLevel() {
        return this.lvl.getLevel();
    }

    public Coordinates getPos() {
        return pos;
    }

    public void setPos(Coordinates coords) {
        this.pos = coords;
    }

    public Level getLvl() {
        return lvl;
    }

    /* todo
        character toString
        set player x, y to -1 when finish mission
        */

}

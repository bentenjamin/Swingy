package com.bwebb.swingy.model.chars;

import com.bwebb.swingy.model.artifacts.Artifacts;
import com.bwebb.swingy.model.chars.player.Level;
import com.bwebb.swingy.model.map.Coordinates;
import com.bwebb.swingy.model.map.MapHandler;
import com.bwebb.swingy.view.ViewInterface;

import static com.bwebb.swingy.model.helper.MathFunctions.rand_gaus;

public class Character {
    private String name = "defaultName";
    private com.bwebb.swingy.model.chars.charClasses.playerClass playerClass = null;
    private Coordinates pos = null;
    //offset is used to keep track of where the player wants to go
    private Coordinates offSet = null;
    private int luck = 0;
    public Artifacts artifacts = null;
    private Level lvl = null;

    //artifacts

    public Character(String name, com.bwebb.swingy.model.chars.charClasses.playerClass playerClass) {
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

    public Coordinates getOffSet() {
        return offSet;
    }

    public void setOffSet(Coordinates offSet) {
        this.offSet = offSet;
    }

    public int getLuck() {
        return luck;
    }

    public String getName() {
        return name;
    }

    public void saveCharacter(ViewInterface display) {
        pos.setX(-1);
        pos.setY(-1);
        display.generalPrint("sAvEd ChArAcTeR");
    }

    public void movePlayer(Coordinates offset, MapHandler map) {
        map.setClearedTile(pos);
        pos.moveBy(offset);
        map.setPlayerPos(pos);
    }

    /* todo
        character toString
        set player x, y to -1 when finish mission
        save
        */

}

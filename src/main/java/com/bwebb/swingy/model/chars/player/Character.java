package com.bwebb.swingy.model.chars.player;

import com.bwebb.swingy.model.artifacts.Artifacts;
import com.bwebb.swingy.model.chars.charClasses.PlayerClass;
import com.bwebb.swingy.model.map.Coordinates;
import com.bwebb.swingy.model.map.MapHandler;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import static com.bwebb.swingy.model.helper.MathFunctions.rand_gaus;

public class Character {
    @NotBlank
    private String name = null;

    @Valid
    private PlayerClass playerClass = null;

    @Valid
    private Coordinates pos = null;
    //offset is used to keep track of where the player wants to go
    private Coordinates offSet = null;

    @Range(max=100)
    private int luck = 0;

    @Valid
    private Artifacts artifacts = null;

    @Valid
    private Level lvl = null;

    public Character(String name, PlayerClass playerClass) {
        this.name = name;
        this.playerClass = playerClass;
        this.artifacts = new Artifacts();
        this.lvl = new Level();

        //luck is random between 0-100 and has a bias to lower ranges (0-40~)
        this.luck = rand_gaus(0, 100);
    }

    public Character() {}

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

    public void movePlayer(Coordinates offset, MapHandler map) {
        map.setClearedTile(pos);
        pos.moveBy(offset);
        map.setPlayerPos(pos);
    }

    public Artifacts getArtifacts() {
        return artifacts;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtifacts(Artifacts artifacts) {
        this.artifacts = artifacts;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void setLvl(Level lvl) {
        this.lvl = lvl;
    }

    public void setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }
}

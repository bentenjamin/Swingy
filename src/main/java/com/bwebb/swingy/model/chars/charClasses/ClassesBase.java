package com.bwebb.swingy.model.chars.charClasses;

public abstract class ClassesBase {
    protected String className = "defaultClass";
    protected int attack = 0;
    protected int defense = 0;
    protected int health = 0;

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getHealth() {
        return this.health;
    }

    public String getClassName() {
        return this.className;
    }

    /* todo
    *   toString for classes*/
}


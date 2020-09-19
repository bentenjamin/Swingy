package com.bwebb.swingy.model.chars.charClasses;

public class ClassesBase {
    protected String className = "defaultClass";
    protected int attack, defense, health = 0;

    public ClassesBase(String className, int attack, int defense, int health) {
        this.className = className;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }

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

    @Override
    public String toString() {
        return "ClassesBase{" +
                "className='" + className + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", health=" + health +
                '}';
    }

    /* todo */
}


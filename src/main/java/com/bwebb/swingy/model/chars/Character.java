package com.bwebb.swingy.model.chars;

import com.bwebb.swingy.model.chars.charClasses.ClassesBase;

import static com.bwebb.swingy.model.helper.MathFunctions.rand_gaus;

public class Character {
    private String name = "defaultName";
    private ClassesBase characterClass = null;
    private int level, experience, luck, x, y = 0;

    //artifacts
    private int weapon, armour, helm = 0;

    public Character(String name, ClassesBase characterClass) {
        this.name = name;
        this.characterClass = characterClass;

        //luck is random between 0-100 and has a bias to lower ranges (0-40~)
        this.luck = rand_gaus(0, 100);
    }

    private int getEffectiveAttack() {
        return this.characterClass.getAttack() + this.weapon;
    }

    private int getEffectiveDefense() {
        return this.characterClass.getDefense() + this.armour;
    }

    private int getEffectiveHealth() {
        return this.characterClass.getHealth() + this.helm;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", characterClass=" + characterClass +
                ", level=" + level +
                ", experience=" + experience +
                ", luck=" + luck +
                ", weapon=" + weapon +
                ", armour=" + armour +
                ", helm=" + helm +
                '}';
    }

    public int getLevel() {
        return this.level;
    }

    /* todo
        character toString
        */

}

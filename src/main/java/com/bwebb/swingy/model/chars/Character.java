package com.bwebb.swingy.model.chars;

import com.bwebb.swingy.model.chars.charClasses.ClassesBase;

import static com.bwebb.swingy.model.helper.MathFunctions.rand_gaus;

public class Character {
    private String name = "defaultName";
    private ClassesBase characterClass = null;
    private int level = 0;
    private int experience = 0;
    private int luck = 0;
    private int weapon = 0;
    private int armour = 0;
    private int helm = 0;
//    private HashMap<String, Artifact> characterArtifacts = new HashMap<String, Artifact>(3);

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

    /* todo
        character toString
        */

}

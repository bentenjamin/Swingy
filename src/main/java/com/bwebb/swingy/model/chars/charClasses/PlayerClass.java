package com.bwebb.swingy.model.chars.charClasses;

import org.hibernate.validator.constraints.Range;

public class PlayerClass {
    @Range(max = 8)
    protected int classIndex;

    public PlayerClass(int classIndex) {
        this.classIndex = classIndex;
    }

    public int getAttack() {
        return (int) ClassesHandler.getClassObj(classIndex)[1];
    }

    public int getDefense() {
        return (int) ClassesHandler.getClassObj(classIndex)[2];
    }

    public int getHealth() {
        return (int) ClassesHandler.getClassObj(classIndex)[3];
    }

    public String getClassName() {
        return (String) ClassesHandler.getClassObj(classIndex)[0];
    }

    public int getClassIndex() {
        return classIndex;
    }
}


package com.bwebb.swingy.model.chars.charClasses;

public class PlayerClass {
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

    /* todo */
}


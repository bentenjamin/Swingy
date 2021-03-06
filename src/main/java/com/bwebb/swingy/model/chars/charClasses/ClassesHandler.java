package com.bwebb.swingy.model.chars.charClasses;

public abstract class ClassesHandler {
    //className, attack, defense, health
    private final static Object[][] classArr = {
            {"Warrior", 100, 100, 100},
            {"Mage", 100, 100, 100},
            {"Rogue", 100, 100, 100},
            {"Paladin", 100, 100, 100},
            {"Archer", 100, 100, 100},
            {"Swordsman", 100, 100, 100},
            {"Bezerker", 100, 100, 100},
            {"Assassin", 100, 100, 100},
            {"Brawler", 100, 100, 100}
    };

    public final static int classAmount = classArr.length;

    public static Object[] getClassObj(int classIndex) {
        return classArr[classIndex];
    }

    public static String[] getClassList() {
        String[] classList = new String[classArr.length];

        for (int i = 0; i < classArr.length; i++) {
            classList[i] = (String) classArr[i][0];
        }

        return classList;
    }
}

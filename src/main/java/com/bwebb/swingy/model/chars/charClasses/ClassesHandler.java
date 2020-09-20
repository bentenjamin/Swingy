package com.bwebb.swingy.model.chars.charClasses;

public abstract class ClassesHandler {
    private static Object[][] classArr = {
            {"Warrior", 5, 5, 5},
            {"Mage", 4, 4, 4}
    };

    public static Object[] getClass(int classIndex) {
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

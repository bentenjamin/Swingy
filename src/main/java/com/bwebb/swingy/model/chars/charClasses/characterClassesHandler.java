package com.bwebb.swingy.model.chars.charClasses;

public abstract class characterClassesHandler {
    private static ClassesBase[] classesList = {
            new Warrior()
    };

    public static String[] getClassesList() {
        String[] stringClassList = new String[classesList.length];
        for (int i = 0; i < classesList.length; i++) {
            stringClassList[i] = classesList[i].getClassName();
        }
        return stringClassList;
    }

    public static ClassesBase getClass(int classIndex) {
        return classesList[classIndex];
    }
}

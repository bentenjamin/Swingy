package com.bwebb.swingy.model.chars.charClasses;

import com.bwebb.swingy.model.chars.charClasses.classList.Mage;
import com.bwebb.swingy.model.chars.charClasses.classList.Warrior;

public abstract class characterClassesHandler {
    private final static ClassesBase[] classesList = {
            new Warrior(),
            new Mage()
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

package com.bwebb.swingy;

import com.bwebb.swingy.model.chars.Character;
import com.bwebb.swingy.model.chars.charClasses.ClassesBase;
import com.bwebb.swingy.model.chars.charClasses.characterClassesHandler;
import com.bwebb.swingy.model.chars.charClasses.classList.Warrior;
import com.github.javafaker.Faker;

import java.util.Arrays;

public class Swingy {
    public static void main(String[] args) {
        Faker faker = new Faker();
        ClassesBase myClass = new Warrior();
        Character hero = new Character(faker.name().firstName(), myClass);
        System.out.println("This is only a test!");
        System.out.println(hero.toString());
        System.out.println("Hello, World!");
    }
    /* todo
        refactor classes again
     */
}

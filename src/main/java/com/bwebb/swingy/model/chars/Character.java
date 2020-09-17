package com.bwebb.swingy.model.chars;

import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.Random;
import static java.lang.Math;

public class Character {
    private Faker faker = new Faker();
    private String characterName = "defaultName";
    private CharacterClass chararcterClass = null;
    private int characterLevel = 0;
    private int characterExp = 0;
    private int characterAttack = 0;
    private int characterDefense = 0;
    private int characterHp = 0;
    private int luck = 0;
    private HashMap<String, Artifact> characterArtifacts = new HashMap<String, Artifact>(3);

    public Character(String characterName, String characterClass) {
        /* random name and class if there is null passed in */
        this.characterName = (characterName == null) ? faker.name.firstName() : characterName;
        this.characterClass = (characterClass == null) ? new CharacterClass() :  new CharacterClass(characterClass);

        this.characterAttack = characterClass.getAttack();
        this.characterDefense = characterClass.getDefense();
        this.characterHp = characterClass.getHp();
        this.luck = calcLuck();
    }

    private int getEffectiveAttack() {
        return this.characterAttack + this.artifacts.get("weapon").getStatBoost();
    }

    private int getEffectiveDefense() {
        return this.characterDefense + this.artifacts.get("armour").getStatBoost();
    }

    private int getEffectiveHp() {
        return this.characterHealth + this.artifacts.get("helm").getStatBoost();
    }

    //luck is random between 0-100 and has a bias to lower ranges (0-40~)
    private int calcLuck() {
        Random random = new Random();
        //the higher base is the more likely your luck is lowish
        int base = 20;
        return Math.ceil((100 / (pow(base, 2) - 1)) * (pow(base, (2 * random.nextFloat())) - 1));
    }

}

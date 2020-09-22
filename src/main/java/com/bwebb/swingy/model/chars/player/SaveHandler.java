package com.bwebb.swingy.model.chars.player;

import com.bwebb.swingy.model.artifacts.Artifacts;
import com.bwebb.swingy.model.chars.charClasses.PlayerClass;
import com.bwebb.swingy.model.map.Coordinates;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveHandler {
    private ArrayList<Character> saves = null;
    private final static String saveFileName = "player_saves.txt";

    public SaveHandler() {
        saves = new ArrayList<Character>();
        readSaves();
    }

    //save order:
    //name,class,x,y,luck,weapon,armour,helm,level,experience
    //0   ,1    ,2,3,4   ,5     ,6     ,7   ,8    ,9
    public String[] playerToArr(Character player) {
        String[] save = new String[10];
        save[0] = player.getName();
        save[1] = Integer.toString(player.getPlayerClass().getClassIndex());
        save[2] = Integer.toString(player.getPos().getX());
        save[3] = Integer.toString(player.getPos().getY());
        save[4] = Integer.toString(player.getLuck());
        save[5] = Integer.toString(player.getArtifacts().getWeapon());
        save[6] = Integer.toString(player.getArtifacts().getArmour());
        save[7] = Integer.toString(player.getArtifacts().getHelm());
        save[8] = Integer.toString(player.getLvl().getLevel());
        save[9] = Integer.toString(player.getLvl().getExperience());

        return save;
    }

    public Character loadCharacterFromArr(String[] stats) {
        Character load = new Character();

        try {
            load.setName(stats[0]);
            load.setPlayerClass(new PlayerClass(Integer.parseInt(stats[1])));
            load.setPos(new Coordinates(Integer.parseInt(stats[2]), Integer.parseInt(stats[3])));
            load.setLuck(Integer.parseInt(stats[4]));
            load.setArtifacts(new Artifacts(Integer.parseInt(stats[5]), Integer.parseInt(stats[6]), Integer.parseInt(stats[7])));
            load.setLvl(new Level(Integer.parseInt(stats[8]), Integer.parseInt(stats[9])));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }

        return load;
    }

    public String[] getSavedCharacterNames() {
        String[] list = new String[saves.size()];

        for (int i = 0; i < saves.size(); i++) {
            list[i] = saves.get(i).getName();
        }

        return list;
    }

    private void parseSaves(String input) {
        String[] characters = input.split(";");

        for (String character : characters) {
            String[] saveArr = character.split(",");
            if (validSave(saveArr))
                saves.add(loadCharacterFromArr(saveArr));
        }
    }

    private boolean validSave(String[] save) {
        return true;
    }

    public Character getSaveByIndex(int index) {
        return saves.get(index);
    }

    public String savesToString() {
        String saveString = "";

        for (Character save : saves)
            saveString += String.join(",", playerToArr(save)) + ";";

        return saveString;
    }

    public void writeSaves() {
        try {
            File saveFile = new File(saveFileName);
            saveFile.createNewFile();

            FileWriter myWriter = new FileWriter(saveFileName);
            myWriter.write(savesToString());
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing.");
            e.printStackTrace();
        }
    }

    public void readSaves() {

        File saveFile = new File(saveFileName);

        if (saveFile.isFile()) try {
            Scanner scanner = new Scanner(saveFile);

            if (scanner.hasNextLine())
                parseSaves(scanner.nextLine());

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing.");
            e.printStackTrace();
        }
    }

    public void purgeCharacters() {
        saves = new ArrayList<Character>();
    }

    public int countSaves() {
        return saves.size();
    }

    public boolean saveExists(Character player) {
        return saves.contains(player);
    }

    public void saveCharacter(Character character) {
        saves.add(character);
    }

    public void deleteSaveByIndex(int index) {
        saves.remove(index);
        writeSaves();
    }

    /* todo
     *   validSave*/
}

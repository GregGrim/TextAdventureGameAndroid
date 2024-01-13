package com.example.textadventuregame.controller;

import com.example.textadventuregame.model.GameModel;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class GameController {
    private GameModel gameModel;


    public void createGameModel() {
        gameModel = new GameModel();
    }

    public void gameStart(String playerName) {
        createGameModel();
        gameModel.createRooms();
        gameModel.createPlayer(playerName, gameModel.getRooms().get(0)); // name entered by user
        gameModel.createInventory();

    }

    public String getLocationImageName() {
        return gameModel.getPlayer().getLocation().getImage();
    }
    public String getLocationText() {
        return gameModel.getPlayer().getLocation().getDescription();
    }

    public List<File> listSavedGames() {
        String directoryPath = "..\\saves";
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            return Arrays.asList(directory.listFiles());
        } else {
            System.out.println("Provided path is not a directory.");
        }
        return null;
    }


}

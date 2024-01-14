package com.example.textadventuregame.controller;

import com.example.textadventuregame.model.GameModel;
import com.example.textadventuregame.model.Room;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
    public String getPlayerInfoText() {
        return gameModel.getPlayer().getPlayerInfo();
    }
    public boolean checkLevelUp() {
        boolean levelUp = gameModel.getPlayer().getXp()>=5;
        if(levelUp) gameModel.getPlayer().setXp(gameModel.getPlayer().getXp()-5);
        return levelUp;
    }
    public boolean roomWithEvent(){
        return gameModel.getPlayer().getLocation().hasEvent();
    }
    public String roomEventHandleText(){
        return gameModel.getPlayer().getLocation().getEventHandle();
    }
    public int getCurrentRoomID(){
        return gameModel.getPlayer().getLocation().getId();
    }

    public void changeRoom(Room room) {
        gameModel.getPlayer().setLocation(room);
    }
    public Room previousRoom() {
        return gameModel.getPlayer().getPassedRooms().peek();
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

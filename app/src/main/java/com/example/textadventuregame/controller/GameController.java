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
        gameModel.createPlayer(playerName); // name entered by user
        gameModel.createInventory();

    }

    public String getLocationImageName() {
        return gameModel.getCurrentRoomByLocation().getImage();
    }
    public String getLocationText() {
        return gameModel.getCurrentRoomByLocation().getDescription();
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
        return gameModel.getCurrentRoomByLocation().hasEvent();
    }
    public String roomEventHandleText(){
        return gameModel.getCurrentRoomByLocation().getEventHandle();
    }

    public void changeLocation(int[] newRoomLocation) {
        gameModel.getPlayer().setLocation(newRoomLocation[0], newRoomLocation[1]);
    }
    public int[] getCurrentLocation() {
        return gameModel.getPlayer().getLocation();
    }
    public boolean isStartingLocation(){
        int [] location = getCurrentLocation();
        return location[0]==15 && location[1]==15;
    }
    public String getCurrentRoomEvent(){
        return gameModel.getCurrentRoomByLocation().getEvent();
    }
    public boolean hasNorthNeighbor(){
        return gameModel.hasNorthNeighbor();
    }
    public boolean hasSouthNeighbor(){
        return gameModel.hasSouthNeighbor();
    }
    public boolean hasWestNeighbor(){
        return gameModel.hasWestNeighbor();
    }
    public boolean hasEastNeighbor(){
        return gameModel.hasEastNeighbor();
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

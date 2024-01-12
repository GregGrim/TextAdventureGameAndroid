package com.example.textadventuregame.controller;

import com.example.textadventuregame.model.GameModel;

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

    public void gameLoad() {
        loadRooms();
        loadPlayer();
        loadInventory();
    }
}

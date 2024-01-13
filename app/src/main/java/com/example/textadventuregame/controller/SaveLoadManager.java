package com.example.textadventuregame.controller;


import com.example.textadventuregame.model.GameModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class SaveLoadManager {
    public static void saveGame(GameModel gameModel) {
        try {

            JAXBContext context = JAXBContext.newInstance(GameModel.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(gameModel,
                    new FileOutputStream("..\\saves\\" + gameModel.getPlayer().getName() + ".xml"));

            System.out.println("Game saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GameModel loadGame(String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(GameModel.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            GameModel gameData = (GameModel) unmarshaller.unmarshal(new FileInputStream(filename));
            System.out.println("Game loaded successfully!");
            return gameData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

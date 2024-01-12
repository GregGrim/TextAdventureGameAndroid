package com.example.textadventuregame.model;


import java.util.ArrayList;
import java.util.List;

public class GameModel {
    public static final String[][] ROOM_DATA = {
            {"The Abyssal Entryway (Starting Room)", "A foreboding entrance to the dungeon.", "entryway.jpg"},
            {"Cryptic Chamber", "A mysterious and dimly lit chamber.", "cryptic_chamber.jpg"},
            {"Forsaken Alchemy Lab", "An abandoned lab filled with ancient alchemical apparatus.", "alchemy_lab.jpg"},
            {"Shadowy Passageway", "A dark and winding passageway with lurking shadows.", "shadowy_passageway.jpg"},
            {"Dim-lit Sanctum", "A quiet sanctum with a faint glow of eerie light.", "dim_lit_sanctum.jpg"},
            {"Wyrm's Roost", "The lair of a slumbering wyrm, guarded by treasure.", "wyrms_roost.jpg"},
            {"Eerie Catacombs", "Catacombs echoing with haunting whispers of the past.", "eerie_catacombs.jpg"},
            {"Astral Nexus", "A room where magical energies converge in an astral nexus.", "astral_nexus.jpg"},
            {"Plunderer's Hideout", "A hideout filled with stolen treasures and ill-gotten gains.", "plunderers_hideout.jpg"},
            {"Nocturnal Ballroom", "A ballroom shrouded in darkness, frozen in a perpetual night.", "nocturnal_ballroom.jpg"},
            {"Thorns and Shadows Den", "A den filled with thorns and shadows, a dangerous retreat.", "thorns_and_shadows_den.jpg"},
            {"Gearworks Forge", "A forge where intricate gears and mechanisms are crafted.", "gearworks_forge.jpg"},
            {"Eldritch Temple", "A temple resonating with ancient and eldritch power.", "eldritch_temple.jpg"},
            {"Maze of Deception", "A maze designed to deceive and confound intruders.", "maze_of_deception.jpg"},
            {"Magma-Forged Bastion", "A bastion forged in magma, standing as a formidable stronghold.", "magma_forged_bastion.jpg"}
    };
    private Player player;
    private List<Room> rooms = new ArrayList<>();
    private Inventory inventory;




    public void createRooms(){
        Room startingRoom = new Room(1,ROOM_DATA[0][0], ROOM_DATA[0][1], ROOM_DATA[0][2]);
        rooms.add(startingRoom);
        for (int i = 2; i < 16; i++) {
            int randomID = (int) (Math.random() * (14)) + 1;
            rooms.add(new Room(i, ROOM_DATA[randomID][0], ROOM_DATA[randomID][1], ROOM_DATA[randomID][2]));
        }
        generateMaze();
    }
    public void generateMaze(){
        RoomConnectionsGenerator generator = new RoomConnectionsGenerator(rooms);
        generator.generateRoomConnections();
        rooms = generator.getRooms();
    }

    public void createPlayer(String name, Room startingLocation) {
        player = new Player(name, startingLocation);
    }

    public void createInventory() {
        inventory = new Inventory();
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

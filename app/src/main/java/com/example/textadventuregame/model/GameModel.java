package com.example.textadventuregame.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameModel {
    public static final String[][] ROOM_DATA = {
            {"Entrance Hall",
                    "You stand in a dimly lit entrance hall. The air is thick with anticipation.",
                    "None",
                    "",
                    "entrance_hall_image",
                    ""},

            {"Dark Corridor",
                    "A dark and eerie corridor stretches ahead. You hear faint whispers in the shadows.",
                    "Monster",
                    "Defeat the lurking monster to proceed.",
                    "dark_corridor_image",
                    "Sword,MedKit"},

            {"Treasure Room",
                    "A room filled with glittering treasures. The air is filled with the scent of wealth.",
                    "Treasure",
                    "Claim the treasure for yourself.",
                    "treasure_image",
                    "MagicSword,Shield"},

            {"Trap Room",
                    "Watch your step! This room is filled with traps. The floor is suspiciously uneven.",
                    "Trap",
                    "Navigate the traps carefully.",
                    "trap_image",
                    ""},

            {"Guardian Chamber",
                    "A powerful guardian blocks your way. Its eyes glow with an otherworldly energy.",
                    "Boss",
                    "Defeat the guardian to access the next level.",
                    "boss_image",
                    "MedKit,Shield"},

            {"Library of Ancient Tomes",
                    "Rows of dusty tomes line the shelves. The knowledge of centuries is at your fingertips.",
                    "None",
                    "",
                    "library_image",
                    ""},

            {"Enchanted Garden",
                    "A magical garden filled with vibrant flowers. The air is infused with a sweet aroma.",
                    "None",
                    "",
                    "garden_image",
                    ""},

            {"Forgotten Alchemy Lab",
                    "Bubbling potions and ancient apparatuses fill the room. A mysterious concoction simmers.",
                    "Potion",
                    "Grab potions",
                    "alchemy_lab_image",
                    "Potion,Potion"},

            {"Hall of Mirrors",
                    "Mirrors reflect your image endlessly. It's disorienting, but there's something intriguing about it.",
                    "None",
                    "",
                    "hall_of_mirrors_image",
                    ""},

            {"Crystal Cavern",
                    "Glowing crystals illuminate the cavern. The walls sparkle with a mesmerizing radiance.",
                    "None",
                    "",
                    "crystal_cavern_image",
                    ""},

            {"Chamber of Whispers",
                    "The air is filled with ghostly whispers. You strain to hear the secrets hidden within.",
                    "None",
                    "",
                    "whisper_chamber_image",
                    ""},

            {"Mystic Observatory",
                    "Telescopes point to the cosmos. The mysteries of the universe unfold before your eyes.",
                    "None",
                    "",
                    "observatory_image",
                    ""},

            {"Dragon's Lair",
                    "A dragon slumbers on a pile of treasures. Approach with caution or seek to claim its hoard.",
                    "Monster",
                    "Decide whether to face the dragon or find another route.",
                    "dragon_lair_image",
                    "DragonBlade"},

            {"Fountain of Youth",
                    "A magical fountain stands in the center. Its waters are said to grant eternal youth.",
                    "None",
                    "",
                    "fountain_image",
                    ""},

            {"Hall of Echoes",
                    "Your footsteps echo through this vast hall. The sound is both haunting and oddly comforting.",
                    "None",
                    "",
                    "hall_of_echoes_image",
                    ""}
    };
    private Player player;
    private List<Room> rooms = new ArrayList<>();
    private Inventory inventory;

    public void createRooms(){
        Room startingRoom = new Room(1,
                ROOM_DATA[0][0],
                ROOM_DATA[0][1],
                ROOM_DATA[0][2],
                ROOM_DATA[0][3],
                ROOM_DATA[0][4],
                new ArrayList<>(Arrays.asList(ROOM_DATA[0][5].split(","))));
        rooms.add(startingRoom);
        for (int i = 2; i < 16; i++) {
            int randomID = (int) (Math.random() * (14)) + 1;
            rooms.add(new Room(i,
                    ROOM_DATA[randomID][0],
                    ROOM_DATA[randomID][1],
                    ROOM_DATA[randomID][2],
                    ROOM_DATA[randomID][3],
                    ROOM_DATA[randomID][4],
                    new ArrayList<>(Arrays.asList(ROOM_DATA[randomID][5].split(",")))));
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

    public Player getPlayer() {
        return player;
    }
}

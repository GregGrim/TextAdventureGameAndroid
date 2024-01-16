package com.example.textadventuregame.model;


import com.example.textadventuregame.model.items.DragonBlade;
import com.example.textadventuregame.model.items.Item;
import com.example.textadventuregame.model.items.MagicSword;
import com.example.textadventuregame.model.items.MedKit;
import com.example.textadventuregame.model.items.Potion;
import com.example.textadventuregame.model.items.Shield;
import com.example.textadventuregame.model.items.Sword;

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
                    "Monster",
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
    private final List<Room> rooms = new ArrayList<>();
    private int[][] map = new int[30][30];
    private List<Item> inventory;
    private Item sword;
    private Shield shield;

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
        MapGenerator generator = new MapGenerator();
        generator.generateMap();
        map = generator.getMap();
    }

    public void createPlayer(String name) {
        player = new Player(name);
    }

    public void createInventory() {
        inventory = new ArrayList<>();
        inventory.add(new MedKit());
        inventory.add(new Potion());
        inventory.add(new DragonBlade());
        inventory.add(new MagicSword());
        inventory.add(new Sword());
        inventory.add(new Shield());
    }

    public Player getPlayer() {
        return player;
    }
    public Room getCurrentRoomByLocation() {
        int id = map[getPlayer().getLocation()[0]][getPlayer().getLocation()[1]];
        for (Room room : rooms) {
            if(room.getId()==id) return room;
        }
        return null;
    }
    public boolean hasNorthNeighbor(){
        return map[getPlayer().getLocation()[0]-1][getPlayer().getLocation()[1]]!=0;
    }
    public boolean hasSouthNeighbor(){
        return map[getPlayer().getLocation()[0]+1][getPlayer().getLocation()[1]]!=0;
    }
    public boolean hasWestNeighbor(){
        return map[getPlayer().getLocation()[0]][getPlayer().getLocation()[1]-1]!=0;
    }
    public boolean hasEastNeighbor(){
        return map[getPlayer().getLocation()[0]][getPlayer().getLocation()[1]+1]!=0;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public Item getSword() {
        return sword;
    }

    public Shield getShield() {
        return shield;
    }

    public void setSword(Item sword) {
        if (this.sword!=null) {
            switch (this.sword.getName()) {
                case "Sword": {
                    Sword swoord = (Sword) this.sword;
                    getPlayer().setPhys_attack(getPlayer().getPhys_attack() - swoord.getPhys_power_bonus());
                    break;
                }
                case "Magic Sword": {
                    MagicSword swoord = (MagicSword) this.sword;
                    getPlayer().setPhys_attack(getPlayer().getPhys_attack() - swoord.getPhys_power_bonus());
                    getPlayer().setMagic_attack(getPlayer().getMagic_attack() - swoord.getMagic_power_bonus());
                    break;
                }
                case "Dragon Blade": {
                    DragonBlade swoord = (DragonBlade) this.sword;
                    getPlayer().setPhys_attack(getPlayer().getPhys_attack() - swoord.getPhys_power_bonus());
                    break;
                }
            }
        }
        this.sword = sword;
        switch (this.sword.getName()) {
            case "Sword": {
                Sword swoord = (Sword) this.sword;
                getPlayer().setPhys_attack(getPlayer().getPhys_attack() + swoord.getPhys_power_bonus());
                break;
            }
            case "Magic Sword": {
                MagicSword swoord = (MagicSword) this.sword;
                getPlayer().setPhys_attack(getPlayer().getPhys_attack() + swoord.getPhys_power_bonus());
                getPlayer().setMagic_attack(getPlayer().getMagic_attack() + swoord.getMagic_power_bonus());
                break;
            }
            case "Dragon Blade": {
                DragonBlade swoord = (DragonBlade) this.sword;
                getPlayer().setPhys_attack(getPlayer().getPhys_attack() + swoord.getPhys_power_bonus());
                break;
            }
        }

    }

    public void setShield(Shield shield) {
        if (this.shield!=null) {
            getPlayer().setShields(getPlayer().getShields()-shield.getShields_power_bonus());
        }
        this.shield = shield;
        getPlayer().setShields(getPlayer().getShields()+shield.getShields_power_bonus());
    }

    public void useOneTimeItem(Item item) {
        if (item.getName().equals("Med Kit")) {
            MedKit medKit = (MedKit) item;
            player.setHp(Math.min(player.getHp() + medKit.getHp_restore(), 100));
        }else if (item.getName().equals("Potion")) {
            Potion potion = (Potion) item;
            player.setMagic_attack(player.getMagic_attack()+potion.getMagic_power_bonus());
            if(player.getHp()-potion.getHp_decrease()<=0){
                player.setAlive(false);
            } else player.setHp(player.getHp()-potion.getHp_decrease());
        }
        inventory.remove(item);
    }
}

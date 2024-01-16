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
                    "A dark and eerie corridor stretches ahead. You hear faint whispers in the shadows. Defeat the lurking monster to proceed.",
                    "Monster",
                    "FIGHT",
                    "dark_corridor_image",
                    "Sword,MedKit"},

            {"Treasure Room",
                    "A room filled with glittering treasures. The air is filled with the scent of wealth.",
                    "Treasure",
                    "COLLECT",
                    "treasure_image",
                    "MagicSword,Shield"},

            {"Trap Room",
                    "Watch your step! This room is filled with traps. The floor is suspiciously uneven. Deactivate the traps if you are brave enough.",
                    "Trap",
                    "DEACTIVATE",
                    "trap_image",
                    ""},

            {"Guardian Chamber",
                    "A powerful guardian blocks your way. Its eyes glow with an otherworldly energy. Defeat the guardian to access the next level.",
                    "Monster",
                    "FIGHT",
                    "boss_image",
                    "MedKit,Shield"},

            {"Library of Ancient Tomes",
                    "Rows of dusty tomes line the shelves. The knowledge of centuries is at your fingertips.",
                    "Treasure",
                    "COLLECT",
                    "library_image",
                    "MedKit"},

            {"Enchanted Garden",
                    "A magical garden filled with vibrant flowers. The air is infused with a sweet aroma.",
                    "None",
                    "",
                    "garden_image",
                    ""},

            {"Forgotten Alchemy Lab",
                    "Bubbling potions and ancient apparatuses fill the room. A mysterious concoction simmers.",
                    "Treasure",
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
                    "Horror",
                    "Listen to them",
                    "whisper_chamber_image",
                    ""},

            {"Mystic Observatory",
                    "Telescopes point to the cosmos. The mysteries of the universe unfold before your eyes.",
                    "None",
                    "",
                    "observatory_image",
                    ""},

            {"Dragon's Lair",
                    "A dragon slumbers on a pile of treasures. Approach with caution or seek to claim its hoard. Decide whether to face the dragon or find another route.",
                    "Dragon",
                    "FIGHT",
                    "dragon_lair_image",
                    "DragonBlade"},

            {"Fountain of Youth",
                    "A magical fountain stands in the center. Its waters are said to grant eternal youth.",
                    "Heal",
                    "Drink water",
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
    private List<String> battleLog;

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
        return map[getPlayer().getLocation()[0]-1][getPlayer().getLocation()[1]]!=0
                && map[getPlayer().getLocation()[0]-1][getPlayer().getLocation()[1]]!=-1;
    }
    public boolean hasSouthNeighbor(){
        return map[getPlayer().getLocation()[0]+1][getPlayer().getLocation()[1]]!=0;
    }
    public boolean hasWestNeighbor(){
        return map[getPlayer().getLocation()[0]][getPlayer().getLocation()[1]-1]!=0
                && map[getPlayer().getLocation()[0]-1][getPlayer().getLocation()[1]]!=-1;
    }
    public boolean hasEastNeighbor(){
        return map[getPlayer().getLocation()[0]][getPlayer().getLocation()[1]+1]!=0
                && map[getPlayer().getLocation()[0]-1][getPlayer().getLocation()[1]]!=-1;
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
    public void doEvent() {
        if(getCurrentRoomByLocation().getEvent().equals("Monster")){
            battleLog = new ArrayList<>();
            int monsterHP = (int)(Math.random()*50)+70;
            int monsterAttack = (int)(Math.random()*5)+1;
            int monsterMagicAttack = (int)(Math.random()*5)+1;
            int monsterShields = (int)(Math.random()*2)+1;
            int playerPower = getPlayer().getPhys_attack()+(int)(0.5*getPlayer().getMagic_attack());
            int playerDamage = playerPower-monsterShields;
            int monsterPower = monsterAttack+(int)(0.5*monsterMagicAttack);
            int monsterDamage = monsterPower-player.getShields();
            while(getPlayer().getHp()>0 && monsterHP>0) {
                monsterHP -= playerDamage;
                String report = getPlayer().getName()+" attacked with power "
                        + playerPower
                        + " and dealt "+playerDamage
                        +" damage. Monster HP="+monsterHP;
                battleLog.add(report);
                if(monsterHP<=0) {
                    battleLog.add("victory");
                    addItemsToInventory(getCurrentRoomByLocation().getEventRewards());
                    getCurrentRoomByLocation().setEvent("None");
                    break;
                }
                player.setHp(player.getHp()-monsterDamage);
                report = "Monster attacked with power "
                        + monsterPower
                        + "and dealt "+monsterDamage
                        +". "+getPlayer().getName()+" HP="+getPlayer().getHp();
                battleLog.add(report);
            }
            if (getPlayer().getHp()<=0) {
                battleLog.add("defeat");
                player.setAlive(false);
            }
        }
        if(getCurrentRoomByLocation().getEvent().equals("Dragon")) {
            battleLog = new ArrayList<>();
            int dragonHP = (int) (Math.random() * 50) + 70;
            int dragonAttack = (int) (Math.random() * 7) + 1;
            int dragonMagicAttack = (int) (Math.random() * 5) + 1;
            int dragonShields = (int) (Math.random() * 4) + 3;
            int playerPower = getPlayer().getPhys_attack() + getPlayer().getMagic_attack();
            int playerDamage = playerPower - dragonShields;
            int dragonPower = dragonAttack + (int) (0.5 * dragonMagicAttack);
            int dragonDamage = dragonPower - player.getShields();
            while (getPlayer().getHp() > 0 && dragonHP > 0) {
                dragonHP -= playerDamage;
                String report = getPlayer().getName() + " attacked with power "
                        + playerPower
                        + " and dealt " + playerDamage
                        + " damage. Dragon HP=" + dragonHP;
                battleLog.add(report);
                if (dragonHP <= 0) {
                    battleLog.add("victory");
                    addItemsToInventory(getCurrentRoomByLocation().getEventRewards());
                    getCurrentRoomByLocation().setEvent("None");
                    break;
                }
                player.setHp(player.getHp() - dragonDamage);
                report = "Monster attacked with power "
                        + dragonPower
                        + "and dealt " + dragonDamage
                        + ". " + getPlayer().getName() + " HP=" + getPlayer().getHp();
                battleLog.add(report);
            }
            if (getPlayer().getHp() <= 0) {
                battleLog.add("defeat");
                player.setAlive(false);
            }
        }

        if(getCurrentRoomByLocation().getEvent().equals("Treasure")){
            addItemsToInventory(getCurrentRoomByLocation().getEventRewards());
            getCurrentRoomByLocation().setEvent("None");
        }
        if(getCurrentRoomByLocation().getEvent().equals("Horror")){
            player.setShields(Math.max(0, player.getShields()-1));
            player.setPhys_attack(Math.max(1, player.getPhys_attack()-2));
            player.setMagic_attack(Math.max(1, player.getMagic_attack()-1));
            getCurrentRoomByLocation().setEvent("None");
        }
        if(getCurrentRoomByLocation().getEvent().equals("Heal")){
            player.setHp(100);
            getCurrentRoomByLocation().setEvent("None");
        }
        if(getCurrentRoomByLocation().getEvent().equals("Trap")){
            player.setHp(Math.max(player.getHp()-(int)(Math.random()*30+10), 1));
            getCurrentRoomByLocation().setEvent("None");
        }
    }
    public List<String> getBattleLog() {
        return battleLog;
    }
    public void addItemsToInventory(List<Item> items) {
        List<Item> newInventory = new ArrayList<>(inventory);
        newInventory.addAll(items);
        inventory = newInventory;
    }
}

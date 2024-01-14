package com.example.textadventuregame.model;

import java.util.Stack;

public class Player {
    private String name;
    private int level;
    private int hp;
    private int xp;
    private int phys_attack;
    private int shields;
    private int magic_attack;
    private Room location;
    private Stack<Room> passedRooms;

    public Player(String name, Room startingLocation) { // initial constructor
        this.name = name;
        this.hp = 100;
        this.phys_attack = 2;
        this.level = 1;
        this.xp = 0;
        this.shields = 0;
        this.magic_attack = 2;
        this.location = startingLocation;
        passedRooms = new Stack<>();
    }

//    public Player(String name, int level, int hp, int phys_attack, int shields, int magic_attack, Room location) { // loading constructor
//        this.name = name;
//        this.level = level;
//        this.hp = hp;
//        this.phys_attack = phys_attack;
//        this.shields = shields;
//        this.magic_attack = magic_attack;
//        this.location=location;
//    }

    public void setLocation(Room location) {
        this.location = location;
    }

    public Room getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
    public String getPlayerInfo(){
        return "HP:"+ this.hp+"  "+"LVL:"+ this.level+"  "+"XP:"+ this.xp+"/5\n"+
                "PA:"+ this.phys_attack+"  "+"MA:"+ this.magic_attack+"  "+"SD:"+ this.shields;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Stack<Room> getPassedRooms() {
        return passedRooms;
    }
}

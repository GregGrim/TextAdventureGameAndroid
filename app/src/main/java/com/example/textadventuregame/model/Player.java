package com.example.textadventuregame.model;

public class Player {
    private final String name;
    private int level;
    private int hp;
    private int xp;
    private int phys_attack;
    private int shields;
    private int magic_attack;
    private int[] location;

    public Player(String name) { // initial constructor
        this.name = name;
        this.hp = 100;
        this.phys_attack = 2;
        this.level = 1;
        this.xp = 0;
        this.shields = 0;
        this.magic_attack = 2;
        this.location = new int[] {15,15};
    }

    public void setLocation(int y, int x) {
        location[0] = y;
        location[1] = x;
    }

    public int[] getLocation() {
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
}

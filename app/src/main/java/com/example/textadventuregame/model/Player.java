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
    private boolean isAlive;

    public Player(String name) { // initial constructor
        this.name = name;
        this.hp = 100;
        this.phys_attack = 2;
        this.level = 1;
        this.xp = 0;
        this.shields = 0;
        this.magic_attack = 2;
        this.location = new int[] {15,15};
        this.isAlive = true;
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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setMagic_attack(int magic_attack) {
        this.magic_attack = magic_attack;
    }

    public int getMagic_attack() {
        return magic_attack;
    }

    public int getPhys_attack() {
        return phys_attack;
    }

    public void setPhys_attack(int phys_attack) {
        this.phys_attack = phys_attack;
    }

    public int getShields() {
        return shields;
    }

    public void setShields(int shields) {
        this.shields = shields;
    }
}

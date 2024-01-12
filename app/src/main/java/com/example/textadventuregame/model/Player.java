package com.example.textadventuregame.model;

public class Player {
    private String name;
    private int level;
    private int hp;
    private int phys_attack;
    private int shields;
    private int magic_attack;

    public Player(String name) { // initial constructor
        this.name = name;
        this.hp = 100;
        this.phys_attack = 2;
        this.level = 1;
        this.shields = 0;
        this.magic_attack = 2;
    }

    public Player(String name, int level, int hp, int phys_attack, int shields, int magic_attack) { // loading constructor
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.phys_attack = phys_attack;
        this.shields = shields;
        this.magic_attack = magic_attack;
    }
}

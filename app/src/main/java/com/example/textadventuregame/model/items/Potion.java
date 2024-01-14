package com.example.textadventuregame.model.items;

public class Potion extends Item{
    private int magic_power_bonus;
    private int hp_decrease;

    public Potion(){
        magic_power_bonus = (int)(Math.random()*5)+1;
        hp_decrease = (int)(Math.random()*20)+1;
    }

    public int getHp_decrease() {
        return hp_decrease;
    }

    public int getMagic_power_bonus() {
        return magic_power_bonus;
    }
}

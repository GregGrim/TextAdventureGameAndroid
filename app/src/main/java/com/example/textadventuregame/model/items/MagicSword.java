package com.example.textadventuregame.model.items;

public class MagicSword extends Item{
    private int phys_power_bonus;
    private int magic_power_bonus;

    public MagicSword(){
        phys_power_bonus = (int)(Math.random()*3)+1;
        magic_power_bonus = (int)(Math.random()*5)+3;
    }

    public int getPhys_power_bonus() {
        return phys_power_bonus;
    }

    public int getMagic_power_bonus() {
        return magic_power_bonus;
    }
}

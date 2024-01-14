package com.example.textadventuregame.model.items;

public class DragonBlade extends Item{
    private int phys_power_bonus;

    public DragonBlade(){
        phys_power_bonus = (int)(Math.random()*5)+10;
    }

    public int getPhys_power_bonus() {
        return phys_power_bonus;
    }
}

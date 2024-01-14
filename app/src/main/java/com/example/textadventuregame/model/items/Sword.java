package com.example.textadventuregame.model.items;

import com.example.textadventuregame.model.items.Item;

public class Sword extends Item {
    private int phys_power_bonus;

    public Sword(){
        phys_power_bonus = (int)(Math.random()*5)+1;
    }

    public int getPhys_power_bonus() {
        return phys_power_bonus;
    }
}

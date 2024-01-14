package com.example.textadventuregame.model.items;

public class Shield extends Item {
    private int shields_power_bonus;

    public Shield(){
        shields_power_bonus = (int)(Math.random()*5)+1;
    }

    public int getShields_power_bonus() {
        return shields_power_bonus;
    }
}

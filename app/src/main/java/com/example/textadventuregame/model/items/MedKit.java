package com.example.textadventuregame.model.items;

public class MedKit extends Item {
    private int hp_restore;
    public MedKit() {
        hp_restore = ((int)(Math.random()*9)+1)*10;
    }

    public int getHp_restore() {
        return hp_restore;
    }
}

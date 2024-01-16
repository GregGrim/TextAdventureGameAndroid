package com.example.textadventuregame.model.items;

public class Shield extends Item {
    private int shields_power_bonus;
    private String name;
    private String imageFileName;
    public Shield(){
        shields_power_bonus = (int)(Math.random()*5)+1;
        this.name="Shield";
        this.imageFileName="shield_image";
    }

    public int getShields_power_bonus() {
        return shields_power_bonus;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getBonusesDesc() {
        return "SD: +"+shields_power_bonus;
    }

    @Override
    public String getImageFileName() {
        return imageFileName;
    }
}

package com.example.textadventuregame.model.items;

public abstract class Item {
    private String name;
    private String imageFileName;

    public String getName() {
        return name;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public abstract String getBonusesDesc();
}

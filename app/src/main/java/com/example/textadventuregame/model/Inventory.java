package com.example.textadventuregame.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final int CAPACITY = 5;
    private List<Item> items;

    public Inventory() { // initial constructor
        items = new ArrayList<>();
    }
    public Inventory(List<Item> savedItems) { // loading constructor
        items = new ArrayList<>(savedItems);
    }


}

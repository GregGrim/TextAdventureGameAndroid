package com.example.textadventuregame.model;

import com.example.textadventuregame.model.items.Item;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private final int id;
    private final String name;
    private String description;
    private String image;
    private boolean visited;
    private String event;
    private String eventHandle;
    private List<Item> eventRewards;

    public Room(int id, String name, String description, String event,String eventHandle,String image, List<String> rewards) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.visited = false;
        this.event = event;
        this.eventHandle = eventHandle;
        if(!rewards.get(0).equals("")) {
            this.eventRewards = new ArrayList<>();
            for (String reward : rewards) {
                this.eventRewards.add(createItem(reward));
            }
        } else {
            this.eventRewards=null;
        }
    }
    public static Item createItem(String className) {
        try {
            Class<?> clazz = Class.forName("model.items." + className);
            Constructor<?> ctor = clazz.getConstructor(String.class);
            Object object = ctor.newInstance("");
            return (Item)object;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getEventHandle() {
        return eventHandle;
    }
    public boolean hasEvent(){
        return !event.equals("None");
    }

    public String getEvent() {
        return event;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        return id == other.getId();
    }
}

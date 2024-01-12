package com.example.textadventuregame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Room {
    private final int id;
    private final String name;
    private String description;
    private String image;

    private List<Room> connections;
    private boolean visited;

    public Room(int id, String name, String description, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.visited = false;
        connections = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Room> getConnections() {
        return connections;
    }
    public void addConnection(Room room) {
        connections.add(room);
    }
    public String printConnections() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Room room : connections) {
            builder.append(room.getId());
            builder.append(" ");
        }
        builder.append("]");
        return  builder.toString();
    }
}

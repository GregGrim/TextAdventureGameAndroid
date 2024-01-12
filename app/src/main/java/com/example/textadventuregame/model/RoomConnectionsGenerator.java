package com.example.textadventuregame.model;

import java.util.ArrayList;
import java.util.List;

public class RoomConnectionsGenerator {

    private List<Room> rooms;

    public RoomConnectionsGenerator(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void generateRoomConnections() { // generates (map) of dungeon
        List<Room> unconnectedRooms = new ArrayList<>(rooms);
        unconnectedRooms.remove(rooms.get(0)); // init unconnected rooms
        List<Room> connectedRooms = new ArrayList<>();
        connectedRooms.add(rooms.get(0)); // init connected rooms with starting room
        while(!allRoomsHaveOneConnection(rooms)) {

            Room currentRoom = connectedRooms.get(getRandomID(connectedRooms.size()));

            List<Room> remainingRooms = new ArrayList<>(rooms);
            remainingRooms.remove(currentRoom); // init remaining rooms

            Room roomToConnect = chooseRoomToConnect(unconnectedRooms, remainingRooms);

            if (!roomsConnected(currentRoom, roomToConnect)) { // check if rooms are already connected
                if (!(currentRoom.getId() == 0
                        && currentRoom.getConnections().size() != 3)&&
                        !(roomToConnect.getId() == 0
                                && roomToConnect.getConnections().size() != 3)) { // check if starting room has 3 connections
                    if (currentRoom.getConnections().size() < 4
                            && roomToConnect.getConnections().size() < 4) { // check total cons under 4
                        if (currentRoom.getConnections().size() > 0
                                && roomToConnect.getConnections().size() > 0) {
                            if(Math.random()>0.5) { // decreasing chance of multiple connections
                                connectRooms(currentRoom, roomToConnect);
                                unconnectedRooms.remove(roomToConnect);
                                connectedRooms.add(roomToConnect);
                            }
                        } else {
                            connectRooms(currentRoom, roomToConnect);
                            unconnectedRooms.remove(roomToConnect);
                            connectedRooms.add(roomToConnect);
                        }
                    }
                }
            }
        }
    }
    private int getRandomID(Integer size){
        return (int) (Math.random() * size);
    }
    private Room chooseRoomToConnect(List<Room> unconnectedRooms, List<Room> remainingRooms) {
        if(unconnectedRooms.size()!=0) return unconnectedRooms.get(getRandomID(unconnectedRooms.size()));
        return remainingRooms.get(getRandomID(remainingRooms.size()));
    }

    private void connectRooms(Room currentRoom, Room roomToConnect) {
        currentRoom.addConnection(roomToConnect);
        roomToConnect.addConnection(currentRoom);
    }

    private boolean roomsConnected(Room currentRoom, Room roomToConnect){
        return currentRoom.getConnections().contains(roomToConnect);
    }
    private boolean allRoomsHaveOneConnection(List<Room> rooms) {
        boolean flag = true;
        for (Room room : rooms) {
            if (room.getConnections().size() == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

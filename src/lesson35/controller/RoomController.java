package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.services.RoomService;

import java.util.Set;

public class RoomController {
    private RoomService roomService = new RoomService();

    public Set<Room> findRoom(Filter filter) {
        return roomService.findRoom(filter);
    }

    public Room addRoom(Room room, String pathToDb) {
        return roomService.addRoom(room,pathToDb );
    }

    public Room deleteRoom(long roomId, String path) {
        return roomService.deleteRoom(roomId, path);
    }
}

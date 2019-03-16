package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.services.RoomService;

import javax.security.auth.login.LoginException;
import java.util.Set;

public class RoomController {
    private RoomService roomService = new RoomService();

    public Set<Room> findRoom(Filter filter, String pathToRoomDb, String pathToHotelDb) throws LoginException {
        return roomService.findRoom(filter, pathToRoomDb, pathToHotelDb);
    }

    public Room addRoom(Room room, String pathToDb, String pathToHotelDb) throws LoginException {
        return roomService.addRoom(room, pathToDb, pathToHotelDb);
    }

    public Room deleteRoom(long roomId, String path) throws LoginException {
        return roomService.deleteRoom(roomId, path);
    }
}

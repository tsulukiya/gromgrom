package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.services.RoomService;

import java.util.Set;

public class RoomRepository {
    private RoomService roomService = new RoomService();

    public Set<Room> findRoom(Filter filter) {
        // TODO: 22.01.2019 Logic in RoomDb.txt
        return null;
    }

    public Room addRoom(Room room) {
        // TODO: 22.01.2019 Logic in RoomDb.txt
        return null;
    }

    public Room deleteRoom(long roomId) {
        // TODO: 22.01.2019 Logic in RoomDb.txt
        return null;
    }
}

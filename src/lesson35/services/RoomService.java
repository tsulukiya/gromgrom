package lesson35.services;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.util.Set;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();

    public Set<Room> findRoom(Filter filter) {
        return roomRepository.findRoom(filter);
    }

    public Room addRoom(Room room) {
        return roomRepository.addRoom(room);
    }

    public Room deleteRoom(long roomId) {
        return roomRepository.deleteRoom(roomId);
    }
}

package lesson35.services;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.util.Set;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();

    public Set<Room> findRoom(Filter filter) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return roomRepository.findRoom(filter);
    }

    public Room addRoom(Room room) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return roomRepository.addRoom(room);
    }

    public Room deleteRoom(long roomId) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return roomRepository.deleteRoom(roomId);
    }
}

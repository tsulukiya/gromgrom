package lesson35.services;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;
import lesson35.repository.ShareRepository;

import java.util.Set;

public class RoomService extends ShareRepository {
    private RoomRepository roomRepository = new RoomRepository();

    public Set<Room> findRoom(Filter filter) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return roomRepository.findRoom(filter);
    }

    public Room addRoom(Room room, String pathToDb) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return roomRepository.addRoom(room, pathToDb);
    }

    public Room deleteRoom(long roomId, String path) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return roomRepository.deleteRoom(roomId, path);
    }
}

package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Room;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class RoomRepository extends ShareRepository {


    public Set<Room> findRoom(Filter filter) {
        // TODO: 22.01.2019 Logic in RoomDb.txt
        return null;
    }

    public Room addRoom(Room room, String pathToDb) {
        try {
            validatePathFileTo(pathToDb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        writeObjectToDb(convertObjectToStringContent(room), pathToDb);
        return room;
    }

    public Room deleteRoom(long roomId, String path) {
        try {
            validatePathFileTo(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        List<Room> roomList = convertContentFromPathToListRoom(path);
        Room roomDelete = null;

        deleteContentFromDb(path);

        for (Room room : roomList) {
            if (room.getId() != roomId) {
                writeObjectToDb(convertObjectToStringContent(room), path);
            } else {
               roomDelete = room;
            }
        }
        return roomDelete;
    }
}


package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.util.List;
import java.util.Set;

public class RoomRepository extends ShareRepository {


    public Set<Room> findRoom(Filter filter) {
        // TODO: 22.01.2019 Logic in RoomDb.txt
        return null;
    }

    public Room addRoom(Room room, String pathToDb) {
        writeObjectToDb(room.toString(), pathToDb);
        return room;
    }

    public Room deleteRoom(long roomId, String path) {
        List<Room> roomList = convertContentFromPathToList(path);
        Room roomDelete = null;
        deleteContentFromDb(path);
        for (Room room : roomList) {
            if (room.getId() != roomId) {
                writeObjectToDb(room.toString(), path);
            } else {
                roomDelete = room;
            }
        }
        return roomDelete;
    }

    @Override
    Room initObject(String[] mas) {
        return new Room(Long.parseLong(mas[0]), Integer.parseInt(mas[1]), Double.parseDouble(mas[2]),
                Boolean.valueOf(mas[3]), Boolean.valueOf(mas[4]), convertStringToDate(mas[5]),
                new Hotel(Long.parseLong(mas[6])));
    }
}


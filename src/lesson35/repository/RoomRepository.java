package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Room;

import java.util.List;
import java.util.Set;

public class RoomRepository extends ShareRepository {


    public Set<Room> findRoom(Filter filter) {
        // TODO: 22.01.2019 Logic in RoomDb.txt
        return null;
    }

    public Room addRoom(Room room, String pathToDb) {
        room.setId(roomId++);
        room.getHotel().setId(hotelId++);
        writeObjectToDb(convertObjectToStringContent(room), pathToDb);
        return room;
    }

    public Room deleteRoom(long roomId, String path) {
//        List<Room> hotelList = convertContentFromPathToListRoom(path);
//        Room roomDelete = null;
//
//        deleteContentFromDb(path);
//
//        for (Hotel hotel : hotelList) {
//            if (hotel.getId() != hotelId) {
//                writeObjectToDb(convertObjectToStringContent(hotel), path);
//            } else {
//                hotelDelete = hotel;
//            }
//        }
        return null;
    }
}


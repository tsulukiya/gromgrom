package lesson35.services;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.repository.HotelRepository;
import lesson35.repository.RoomRepository;
import lesson35.repository.ShareRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();

    public Set<Room> findRoom(Filter filter, String pathToRoomDb, String pathToHotelDb) {
        return roomRepository.findRoom(filter, pathToRoomDb, pathToHotelDb);
    }

    public Room addRoom(Room room, String pathToDb, String pathToHotelDb) {
        room.setId(setRoomId());
        validateRoomToNullFields(room);
        validateHaveHotelWithSearchIdInHotelDb(room.getHotel().getId(), pathToHotelDb);
        return roomRepository.addRoom(room, pathToDb);
    }

    public Room deleteRoom(long roomId, String path) {
        validateHaveRoomWithSearchIdInRoomDb(roomId, path);
        return roomRepository.deleteRoom(roomId, path);
    }


    private long setRoomId() {
        Random random = new Random();
        return random.nextInt(10000) + 101;
    }

    private void validateRoomToNullFields(Room room) {
        if (room.getId() == 0 || room.getNumberOfGuests() == 0 || room.getDateAvailableFrom() == null ||
                room.getPrice() == 0.0 || room.getHotel() == null) {
            throw new NullPointerException("Room with ID: " + room.getId() + " have null field. Method - " +
                    "validateRoomToNullFields. Class - RoomService");
        }
    }

    private void validateHaveHotelWithSearchIdInHotelDb(long hotelId, String path) {
        @SuppressWarnings("unchecked")
        List<Hotel> hotelList = new HotelRepository().convertContentFromPathToList(path);

        int count = 0;

        for (Hotel hotel1 : hotelList) {
            if (hotelId == hotel1.getId()) {
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("Hotel with ID:" + hotelId + " is not have HotelDB" + path +
                    "Class - RoomService. Method - validateHaveHotelWithSearchIdInHotelDb.");
        }
    }

    private void validateHaveRoomWithSearchIdInRoomDb(long roomId, String path) {
        @SuppressWarnings("unchecked")
        List<Room> roomList = roomRepository.convertContentFromPathToList(path);
        int count = 0;
        for (Room room1 : roomList) {
            if (roomId == room1.getId()) {
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("Room with ID:" + roomId + " is not have RoomDB" + path +
                    "Class - RoomService. Method - validateHaveRoomWithSearchIdInRoomDb.");
        }
    }

}

package lesson35.services;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();

    public Set<Room> findRoom(Filter filter) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return roomRepository.findRoom(filter);
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
        List<Hotel> hotelList = convertContentFromPathToListHotel(path);

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

    private List<Hotel> convertContentFromPathToListHotel(String path) {
        File file = new File(path);
        List<Hotel> hotelList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] mas = line.split(",");
                Hotel hotel = new Hotel(Long.parseLong(mas[0]));
                hotelList.add(hotel);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return hotelList;
    }

    private void validateHaveRoomWithSearchIdInRoomDb(long roomId, String path) {
        List<Room> roomList = convertContentFromPathToListRoom(path);
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

    public List<Room> convertContentFromPathToListRoom(String path) {
        File file = new File(path);
        List<Room> roomList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] mas = line.split(",");
                Room room = new Room(Long.parseLong(mas[0]),Integer.parseInt(mas[1]), Double.parseDouble(mas[2]),
                        Boolean.valueOf(mas[3]), Boolean.valueOf(mas[4]), convertStringToDate(mas[5]),
                        new Hotel(Long.valueOf(mas[6])));
                roomList.add(room);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return roomList;
    }

    private Date convertStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.err.println(e.getErrorOffset());
        }
        return date;
    }




}

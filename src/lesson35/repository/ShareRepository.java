package lesson35.repository;


import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ShareRepository {
    public static long roomId = 201;
    public static long hotelId = 301;


    public void writeObjectToDb(String contentToWriteDb, String pathToDb) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToDb, true))) {
            bufferedWriter.append(contentToWriteDb);
            bufferedWriter.append("\n");
        } catch (IOException e) {
            System.err.println(e.getMessage() + pathToDb);
        }
    }

    public List<Hotel> convertContentFromPathToListHotel(String path) {
        File file = new File(path);
        List<Hotel> hotelList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] mas = line.split(",");
                Hotel hotel = new Hotel(Long.parseLong(mas[0]), mas[1], mas[2], mas[3], mas[4]);
                hotelList.add(hotel);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return hotelList;
    }

//    public List<Room> convertContentFromPathToListRoom(String path) {
//        File file = new File(path);
//        List<Room> roomsList = new ArrayList<>();
//
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] mas = line.split(",");
//                Room room = new Room(Long.parseLong(mas[0]), Integer.parseInt(mas[1]), Double.parseDouble(mas[2]),
//                        Boolean.parseBoolean(mas[3]), Boolean.parseBoolean(mas[4]),
//                        Date.parseDate(mas[5]),  mas[6]);
//                roomsList.add(room);
//            }
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//        return hotelList;
//    }

    public void deleteContentFromDb(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write("");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public String convertObjectToStringContent(Hotel hotel) {
        return hotel.getId() + "," + hotel.getName() + "," + hotel.getCountry() + "," +
                hotel.getCity() + "," + hotel.getStreet();
    }


    public String convertObjectToStringContent(User user) {
        return user.getId() + "," + user.getUserName() + "," + user.getCountry() +
                "," + user.getPassword() + "," + user.getUserType();
    }

    public String convertObjectToStringContent(Room room) {
        return room.getId() + "," + room.getNumberOfGuests() + "," + room.getPrice() + "," + room.isBreakfastIncluded()
                + "," + room.isPetsAllowed() + "," + room.getDateAvailableFrom() + "," + room.getHotel();
    }


}

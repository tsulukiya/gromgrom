package lesson35.repository;


import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ShareRepository <T> {

    public void writeObjectToDb(String contentToWriteDb, String pathToDb) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToDb, true))) {
            validatePathFileTo(pathToDb);
            bufferedWriter.append(contentToWriteDb);
            bufferedWriter.append("\n");
        } catch (IOException e) {
            System.err.println(e.getMessage() + pathToDb);
        }
    }

    public List<T> convertContentFromPathToList(String path) {
        File file = new File(path);
        T t;
        List<T> objectList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] mas = line.split(",");
                t = initObject(mas, t);

                objectList.add(mas, t );
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return objectList;
    }

    private Hotel initObject (String [] mas, Hotel hotel) {
        hotel = new Hotel(Long.parseLong(mas[0]), mas[1], mas[2], mas[3], mas[4]);
        return hotel;
    }

    private Room initObject (String [] mas, Room room) {
        room = new Room(Long.parseLong(mas[0]), Integer.parseInt(mas[1]), Double.parseDouble(mas[2]),
                Boolean.valueOf(mas[3]), Boolean.valueOf(mas[4]), convertStringToDate(mas[5]),
                new Hotel(Long.parseLong(mas[6])));
        return room;
    }

    public List<Room> convertContentFromPathToListRoom(String path) {
        File file = new File(path);
        List<Room> roomList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] mas = line.split(",");
                Room room = new Room(Long.parseLong(mas[0]), Integer.parseInt(mas[1]), Double.parseDouble(mas[2]),
                        Boolean.valueOf(mas[3]), Boolean.valueOf(mas[4]), convertStringToDate(mas[5]),
                        new Hotel(Long.parseLong(mas[6])));
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
                + "," + room.isPetsAllowed() + "," + dateFormat(room.getDateAvailableFrom()) + "," + room.getHotel().getId();
    }


    public void validatePathFileTo(String path) throws IOException {
        File fileTo = new File(path);

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist.");
        }
        if (!fileTo.canWrite()) {
            throw new IOException("File " + fileTo + " does not have permission to be written.");
        }
    }

    private String dateFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }


}

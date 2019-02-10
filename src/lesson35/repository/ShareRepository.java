package lesson35.repository;


import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ShareRepository {

    public void writeObjectToDb(String contentToWriteDb, String pathToDb) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToDb, true))) {
            validatePathFileTo(pathToDb);
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


    public void validatePathFileTo(String path) throws IOException {
        File fileTo = new File(path);

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist.");
        }
        if (!fileTo.canWrite()) {
            throw new IOException("File " + fileTo + " does not have permission to be written.");
        }
    }


}

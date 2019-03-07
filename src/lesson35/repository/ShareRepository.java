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

public  abstract class ShareRepository <T> {

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
        List<T> objectList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] mas = line.split(",");
                objectList.add(initObject(mas));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return objectList;
    }

    abstract T initObject(String [] mas);

    public Date convertStringToDate(String dateString) {
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

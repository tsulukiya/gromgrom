package lesson35.repository;

import lesson35.model.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShareRepository {


    public void writeObjectToDb(String contentToWriteDb, String pathToDb) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToDb, true))) {
            bufferedWriter.append(contentToWriteDb);
            bufferedWriter.append("\n");
        } catch (IOException e) {
            System.err.println(e.getMessage() + pathToDb);
        }
    }

    public List<Hotel> listHotel(String path) {
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
}

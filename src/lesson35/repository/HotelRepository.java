package lesson35.repository;

import lesson35.model.Hotel;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository {
    private ShareRepository shareRepository = new ShareRepository();
    private static long hotelId = 201;

    public Hotel findHotelByName(String name) {
        // TODO: 22.01.2019 some logic for HotelDb.txt
        return null;
    }

    public Hotel findHotelByCity(String city) {
        // TODO: 22.01.2019 some logic for HotelDb.txt
        return null;
    }


    public Hotel addHotel(Hotel hotel, String pathToDb) {
        hotel.setId(hotelId++);
        String contentToHotelDb = hotel.getId() + "," + hotel.getName() + "," + hotel.getCountry() + "," +
                hotel.getCity() + "," + hotel.getStreet();
        shareRepository.writeObjectToDb(contentToHotelDb, pathToDb);
        return hotel;
    }

    public Hotel deleteHotel(long hotelId, String path) {
        List<Hotel> hotelList = shareRepository.listHotel(path);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write("");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        for (Hotel hotel : hotelList) {
            if (hotel.getId() != hotelId) {
                String contentToHotelDb = hotel.getId() + "," + hotel.getName() + "," + hotel.getCountry() + "," +
                        hotel.getCity() + "," + hotel.getStreet();
                shareRepository.writeObjectToDb(contentToHotelDb, path);
            }
        }
        return null;

    }
}

package lesson35.services;

import lesson35.model.Hotel;
import lesson35.model.User;
import lesson35.repository.HotelRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();

    public Hotel findHotelByName(String name, String pathHotelDb) {
        return hotelRepository.findHotelByName(name, pathHotelDb);
    }

    public Hotel findHotelByCity(String city, String pathHotelDb) {
        return hotelRepository.findHotelByCity(city, pathHotelDb);
    }

    public Hotel addHotel(Hotel hotel, String pathToDb) {
        hotel.setId(setHotelId());
        validateHotelToNullFields(hotel);
        validateHotelDuplicatesInHotelDb(hotel, pathToDb);
        return hotelRepository.addHotel(hotel, pathToDb);
    }

    public Hotel deleteHotel(long hotelId, String path) {
        validateHaveHotelWithSearchIdInHotelDb(hotelId, path);
        return hotelRepository.deleteHotel(hotelId, path);
    }


    private void validateHotelToNullFields(Hotel hotel) {

        if (hotel.getId() == 0 || hotel.getName() == null || hotel.getCountry() == null ||
                hotel.getCity() == null || hotel.getStreet() == null) {
            throw new NullPointerException("Hotel with ID: " + hotel.getId() + " have null field. Method - " +
                    "validateHotelToNullFields. Class - HotelService");
        }
    }


    private long setHotelId() {
        Random random = new Random();
        return random.nextInt(10000) + 101;
    }


    private void validateHotelDuplicatesInHotelDb(Hotel hotel, String path) {
        List<Hotel> hotelList = convertContentFromPathToListHotel(path);

        for (Hotel hotel1 : hotelList) {
            if (hotel.getId() == hotel1.getId()) {
                throw new ConcurrentModificationException("Hotel with ID:" + hotel.getId() + " is have DB" + path +
                        "Class - HotelService. Method - validateHotelDuplicatesInUserDb.");
            }
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
                    "Class - HotelService. Method - validateHaveHotelWithSearchIdInHotelDb.");
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

}

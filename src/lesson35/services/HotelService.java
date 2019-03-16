package lesson35.services;

import lesson35.model.Hotel;
import lesson35.model.User;
import lesson35.repository.HotelRepository;
import lesson35.repository.UserRepository;

import javax.security.auth.login.LoginException;
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
    private UserRepository userRepository = new UserRepository();

    public Hotel findHotelByName(String name, String pathHotelDb) throws LoginException {
        userRepository.checkLoginUser();
        return hotelRepository.findHotelByName(name, pathHotelDb);
    }

    public Hotel findHotelByCity(String city, String pathHotelDb) throws LoginException {
        userRepository.checkLoginUser();
        return hotelRepository.findHotelByCity(city, pathHotelDb);
    }

    public Hotel addHotel(Hotel hotel, String pathToDb) throws LoginException {
        userRepository.checkLoginUser();
        userRepository.checkUserType();
        hotel.setId(setHotelId());
        validateHotelToNullFields(hotel);
        validateHotelDuplicatesInHotelDb(hotel, pathToDb);
        return hotelRepository.addHotel(hotel, pathToDb);
    }

    public Hotel deleteHotel(long hotelId, String path) throws LoginException {
        userRepository.checkLoginUser();
        userRepository.checkUserType();
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
        @SuppressWarnings("unchecked")
        List<Hotel> hotelList = hotelRepository.convertContentFromPathToList(path);

        for (Hotel hotel1 : hotelList) {
            if (hotel.getId() == hotel1.getId()) {
                throw new ConcurrentModificationException("Hotel with ID:" + hotel.getId() + " is have DB" + path +
                        "Class - HotelService. Method - validateHotelDuplicatesInUserDb.");
            }
        }
    }


    private void validateHaveHotelWithSearchIdInHotelDb(long hotelId, String path) {
        @SuppressWarnings("unchecked")
        List<Hotel> hotelList = hotelRepository.convertContentFromPathToList(path);

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

}

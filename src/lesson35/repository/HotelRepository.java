package lesson35.repository;

import lesson35.model.Hotel;

import java.io.IOException;
import java.util.List;

public class HotelRepository extends ShareRepository {

    public Hotel findHotelByName(String name, String pathHotelDb) {
        List<Hotel>hotelList = convertContentFromPathToListHotel(pathHotelDb);
        Hotel hotelRes = null;

        for (Hotel hotel : hotelList) {
            if (hotel.getName().equals(name)) {
                hotelRes = hotel;
            }
        }
        System.out.println(hotelRes);
        return hotelRes;
    }

    public Hotel findHotelByCity(String city, String pathHotelDb) {
        List<Hotel>hotelList = convertContentFromPathToListHotel(pathHotelDb);
        Hotel hotelRes = null;

        for (Hotel hotel : hotelList) {
            if (hotel.getCity().equals(city)) {
                hotelRes = hotel;
            }
        }
        System.out.println(hotelRes);
        return hotelRes;
    }


    public Hotel addHotel(Hotel hotel, String pathToDb) {
        try {
            validatePathFileTo(pathToDb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        writeObjectToDb(convertObjectToStringContent(hotel), pathToDb);
        return hotel;
    }


    public Hotel deleteHotel(long hotelId, String path) {
        try {
            validatePathFileTo(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        List<Hotel> hotelList = convertContentFromPathToListHotel(path);
        Hotel hotelDelete = null;

        deleteContentFromDb(path);

        for (Hotel hotel : hotelList) {
            if (hotel.getId() != hotelId) {
                writeObjectToDb(convertObjectToStringContent(hotel), path);
            } else {
                hotelDelete = hotel;
            }
        }
        return hotelDelete;
    }
}
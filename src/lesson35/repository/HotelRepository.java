package lesson35.repository;

import lesson35.model.Hotel;

import java.io.IOException;
import java.util.List;

public class HotelRepository extends ShareRepository {

    public Hotel findHotelByName(String name) {
        // TODO: 22.01.2019 some logic for HotelDb.txt
        return null;
    }

    public Hotel findHotelByCity(String city) {
        // TODO: 22.01.2019 some logic for HotelDb.txt
        return null;
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
package lesson35.repository;

import lesson35.model.Hotel;

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
        hotel.setId(hotelId++);
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
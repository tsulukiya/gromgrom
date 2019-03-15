package lesson35.repository;

import lesson35.model.Hotel;

import java.io.IOException;
import java.util.List;

public class HotelRepository extends ShareRepository {
    @Override
    Hotel initObject(String[] mas) {
        return new Hotel(Long.parseLong(mas[0]), mas[1], mas[2], mas[3], mas[4]);

    }

    public Hotel findHotelByName(String name, String pathHotelDb) {
        @SuppressWarnings("unchecked")
        List<Hotel> hotelList = convertContentFromPathToList(pathHotelDb);
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
        @SuppressWarnings("unchecked")
        List<Hotel> hotelList = convertContentFromPathToList(pathHotelDb);
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
        writeObjectToDb(hotel.toString(), pathToDb);
        return hotel;
    }


    public Hotel deleteHotel(long hotelId, String path) {
        @SuppressWarnings("unchecked")
        List<Hotel> hotelList = convertContentFromPathToList(path);
        Hotel hotelDelete = null;

        deleteContentFromDb(path);

        for (Hotel hotel : hotelList) {
            if (hotel.getId() != hotelId) {
                writeObjectToDb(hotel.toString(), path);
            } else {
                hotelDelete = hotel;
            }
        }
        return hotelDelete;
    }

}
package lesson35.services;

import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

import java.io.IOException;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();
    private long idHotel = 201;

//    public Hotel findHotelByName(String name) {
//        // TODO: 22.01.2019 VALIDATE LOGIC
//        return hotelRepository.findHotelByName(name);
//    }
//
//    public Hotel findHotelByCity(String city) {
//        // TODO: 22.01.2019 VALIDATE LOGIC
//        return hotelRepository.findHotelByCity(city);
//    }

    public Hotel addHotel(Hotel hotel, String pathToDb) {
        hotel.setId(idHotel++);
        validateWriteToDb(hotel, pathToDb);
        return hotelRepository.addHotel(hotel, pathToDb);

    }

    public Hotel deleteHotel(long hotelId, String path) {
        return hotelRepository.deleteHotel(hotelId, path);
    }

    private void validateWriteToDb(Hotel hotel, String pathToDb) {

        if (hotel.getId() == 0 || hotel.getName() == null || hotel.getCountry() == null ||
                hotel.getCity() == null || hotel.getStreet() == null) {
            throw new NullPointerException("Hotel with ID: " + hotel.getId() +
                    " have null field. Method - validateWriteToDb");
        }
    }
}

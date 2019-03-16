package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.services.HotelService;

import javax.security.auth.login.LoginException;

public class HotelController {
    private HotelService hotelService = new HotelService();

    public Hotel findHotelByName(String name, String pathHotelDb) throws LoginException {
        return hotelService.findHotelByName(name, pathHotelDb);
    }

    public Hotel findHotelByCity(String city,String pathHotelDb) throws LoginException {
        return hotelService.findHotelByCity(city,pathHotelDb);
    }

    public Hotel addHotel(Hotel hotel, String pathToDb) throws LoginException {
        return hotelService.addHotel(hotel, pathToDb);
    }

    public Hotel deleteHotel(long hotelId, String path) throws LoginException {
        return hotelService.deleteHotel(hotelId, path);
    }
}

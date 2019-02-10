package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.services.HotelService;

public class HotelController {
    private HotelService hotelService = new HotelService();

    public Hotel findHotelByName(String name, String pathHotelDb) {
        return hotelService.findHotelByName(name, pathHotelDb);
    }

    public Hotel findHotelByCity(String city,String pathHotelDb) {
        return hotelService.findHotelByCity(city,pathHotelDb);
    }

    public Hotel addHotel(Hotel hotel, String pathToDb) {
        return hotelService.addHotel(hotel, pathToDb);
    }

    public Hotel deleteHotel(long hotelId, String path) {
        return hotelService.deleteHotel(hotelId, path);
    }
}

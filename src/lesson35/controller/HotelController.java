package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.services.HotelService;

import java.io.IOException;

public class HotelController {
    private HotelService hotelService = new HotelService();

//    public Hotel findHotelByName(String name) {
//        return hotelService.findHotelByName(name);
//    }
//
//    public Hotel findHotelByCity(String city) {
//        return hotelService.findHotelByCity(city);
//    }

    public Hotel addHotel(Hotel hotel, String pathToDb) {
        return hotelService.addHotel(hotel, pathToDb);
    }

    public Hotel deleteHotel(long hotelId, String path) throws IOException{
        return hotelService.deleteHotel(hotelId, path);
    }
}

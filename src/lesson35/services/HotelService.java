package lesson35.services;

import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();

    public Hotel findHotelByName(String name) {
        return hotelRepository.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city) {
        return hotelRepository.findHotelByCity(city);
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.addHotel(hotel);
    }

    public Hotel deleteHotel(long hotelId) {
        return hotelRepository.deleteHotel(hotelId);
    }
}

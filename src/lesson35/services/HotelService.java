package lesson35.services;

import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

public class HotelService {
    private HotelRepository hotelRepository = new HotelRepository();

    public Hotel findHotelByName(String name) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return hotelRepository.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return hotelRepository.findHotelByCity(city);
    }

    public Hotel addHotel(Hotel hotel) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return hotelRepository.addHotel(hotel);
    }

    public Hotel deleteHotel(long hotelId) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        return hotelRepository.deleteHotel(hotelId);
    }
}

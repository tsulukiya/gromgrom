package lesson35.repository;

import lesson35.model.Hotel;

public class HotelRepository {
    private ShareRepository shareRepository = new ShareRepository();
    private static long hotelId = 201;

    public Hotel findHotelByName(String name) {
        // TODO: 22.01.2019 some logic for HotelDb.txt
        return null;
    }

    public Hotel findHotelByCity(String city) {
        // TODO: 22.01.2019 some logic for HotelDb.txt
        return null;
    }


    public Hotel addHotel(Hotel hotel) {
        String pathToDb = "/Users/macbook/Documents/DB final project/HotelDb.txt";
        hotel.setId(hotelId++);
        String contentToHotelDb = hotel.getId() + "," + hotel.getName() + "," + hotel.getCountry() + "," +
                hotel.getCity() + "," + hotel.getStreet();
        shareRepository.writeObjectToDb(contentToHotelDb, pathToDb);
        return hotel;
    }

    public Hotel deleteHotel(long hotelId) {
        // TODO: 22.01.2019 some logic for HotelDb.txt
        return null;
    }


}

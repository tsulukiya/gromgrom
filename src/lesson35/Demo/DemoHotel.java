package lesson35.Demo;

import lesson35.controller.HotelController;
import lesson35.model.Hotel;

public class DemoHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Redisson", "Ukraine", "Kiev", "Yaroslaviv Val" );
        Hotel hotel2 = new Hotel("Redisson", "Ukraine", "Kiev", "Yaroslaviv Val" );
        Hotel hotel3 = new Hotel("Redisson", "Ukraine", "Kiev", "Yaroslaviv Val" );

        HotelController hotelController = new HotelController();
        hotelController.addHotel(hotel, "/Users/macbook/Documents/DB final project/HotelDb.txt");
        hotelController.addHotel(hotel2, "/Users/macbook/Documents/DB final project/HotelDb.txt");
        hotelController.addHotel(hotel3, "/Users/macbook/Documents/DB final project/HotelDb.txt");


        hotelController.deleteHotel(203, "/Users/macbook/Documents/DB final project/HotelDb.txt");
    }
}

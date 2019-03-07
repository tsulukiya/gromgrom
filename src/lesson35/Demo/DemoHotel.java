package lesson35.Demo;

import lesson35.controller.HotelController;
import lesson35.model.Hotel;

import java.io.IOException;

public class DemoHotel {
    public static void main(String[] args) throws IOException {
//        Hotel hotel = new Hotel("Redisson ParkInn", "Ukraine", "Sevastopol", "Yaroslaviv Val" );
//        Hotel hotel2 = new Hotel("Redisson Blue", "Ukraine", "Kiev", "Yaroslaviv Val" );
//        Hotel hotel3 = new Hotel("Redisson Red", "Ukraine", "Kiev", "Yaroslaviv Val" );

        HotelController hotelController = new HotelController();
//        hotelController.addHotel(hotel, "/Users/macbook/Documents/DB final project/HotelDb.txt");
//        hotelController.addHotel(hotel2, "/Users/macbook/Documents/DB final project/HotelDb.txt");
//        hotelController.addHotel(hotel3, "/Users/macbook/Documents/DB final project/HotelDb.txt");


      // hotelController.deleteHotel(9834, "/Users/macbook/Documents/DB final project/HotelDb.txt");

        //hotelController.findHotelByName("Redisson Red", "/Users/macbook/Documents/DB final project/HotelDb.txt");
        //hotelController.findHotelByCity("Sevastopol", "/Users/macbook/Documents/DB final project/HotelDb.txt");
    }
}

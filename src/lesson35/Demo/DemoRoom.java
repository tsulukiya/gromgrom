package lesson35.Demo;

import lesson35.controller.RoomController;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.util.Date;

public class DemoRoom {

    public static void main(String[] args) {

        Room room1 = new Room(4, 1200.5, true, false, new Date(), new Hotel(9340));
        Room room2 = new Room(2, 980.5, true, false, new Date(), new Hotel(5012));
        Room room3 = new Room(1, 1000.5, false, false, new Date(), new Hotel(993));

        RoomController roomController = new RoomController();
              roomController.addRoom(room1, "/Users/macbook/Documents/DB final project/RoomDb.txt",
                "/Users/macbook/Documents/DB final project/HotelDb.txt");
        roomController.addRoom(room2, "/Users/macbook/Documents/DB final project/RoomDb.txt",
                "/Users/macbook/Documents/DB final project/HotelDb.txt");
        roomController.addRoom(room3, "/Users/macbook/Documents/DB final project/RoomDb.txt",
                "/Users/macbook/Documents/DB final project/HotelDb.txt");

        //roomController.deleteRoom(6987, "/Users/macbook/Documents/DB final project/RoomDb.txt");


    }
}

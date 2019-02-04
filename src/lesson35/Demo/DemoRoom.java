package lesson35.Demo;

import lesson35.controller.RoomController;
import lesson35.model.Hotel;
import lesson35.model.Room;

public class DemoRoom {

    public static void main(String[] args) {


        Hotel hotel = new Hotel("Redisson", "Ukraine", "Kiev", "Yaroslaviv Val");
        Hotel hotel2 = new Hotel("Redisson", "Ukraine", "Kiev", "Yaroslaviv Val");
        Hotel hotel3 = new Hotel("Redisson", "Ukraine", "Kiev", "Yaroslaviv Val");


        Room room1 = new Room(4, 1200.5, true, false, hotel);
        Room room2 = new Room(2, 980.5, true, false, hotel2);
        Room room3 = new Room(1, 1000.5, false, false, hotel3);

        RoomController roomController = new RoomController();
        roomController.addRoom(room1, "/Users/macbook/Documents/DB final project/RoomDb.txt");
        roomController.addRoom(room2, "/Users/macbook/Documents/DB final project/RoomDb.txt");
        roomController.addRoom(room3, "/Users/macbook/Documents/DB final project/RoomDb.txt");


    }
}

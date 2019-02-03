package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.services.UserService;

import java.io.IOException;
import java.util.Set;

public class UserController {
    private UserService userService = new UserService();
    private HotelController hotelController = new HotelController();
    private OrderController orderController = new OrderController();
    private RoomController roomController = new RoomController();

    public User registerUser(User user, String pathToDb) throws IOException {
        return userService.registerUser(user, pathToDb);
    }

//    public Hotel findHotelByName(String name) {
//        return hotelController.findHotelByName(name);
//    }

//    public Hotel findHotelByCity(String city) {
//        return hotelController.findHotelByCity(city);
//    }

    public Hotel addHotel(Hotel hotel, String pathToDb) {
        return hotelController.addHotel(hotel, pathToDb);
    }

    public Hotel deleteHotel(long hotelId, String path) {
        return hotelController.deleteHotel(hotelId, path);
    }

//    public void bookRoom(long roomId, long userId) {
//        orderController.bookRoom(roomId, userId);
//    }
//
//    public void cancelReservation(long roomId, long userId) {
//        orderController.cancelReservation(roomId, userId);
//    }
//
//    public Set<Room> findRoom(Filter filter) {
//        return roomController.findRoom(filter);
//    }
//
//    public Room addRoom(Room room) {
//        return roomController.addRoom(room);
//    }
//
//    public Room deleteRoom(long roomId) {
//        return roomController.deleteRoom(roomId);
//    }
}

package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.services.UserService;

import java.util.Set;

public class UserController {
    private UserService userService = new UserService();
    private HotelController hotelController = new HotelController();
    private OrderController orderController = new OrderController();
    private RoomController roomController = new RoomController();

    public User registerUser(User user) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        return userService.registerUser(user);
    }

    public Hotel findHotelByName(String name) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        return hotelController.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        return hotelController.findHotelByCity(city);
    }

    public Hotel addHotel(Hotel hotel) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        return hotelController.addHotel(hotel);
    }

    public Hotel deleteHotel(long hotelId) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        return hotelController.deleteHotel(hotelId);
    }

    public void bookRoom(long roomId, long userId) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        orderController.bookRoom(roomId, userId);
    }

    public void cancelReservation(long roomId, long userId) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        orderController.cancelReservation(roomId, userId);
    }

    public Set<Room> findRoom(Filter filter) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        return roomController.findRoom(filter);
    }

    public Room addRoom(Room room) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        return roomController.addRoom(room);
    }

    public Room deleteRoom(long roomId) {
        //// TODO: 22.01.2019 VALIDATE LOGIC
        return roomController.deleteRoom(roomId);
    }
}

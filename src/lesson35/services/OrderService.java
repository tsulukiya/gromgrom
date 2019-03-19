package lesson35.services;

import lesson35.model.Room;
import lesson35.model.User;
import lesson35.repository.OrderRepository;
import lesson35.repository.UserRepository;

import javax.security.auth.login.LoginException;
import java.util.List;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private UserRepository userRepository = new UserRepository();

    public void bookRoom(long roomId, long userId, long hotelId) throws LoginException {

    }

    public void cancelReservation(long roomId, long userId) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        orderRepository.cancelReservation(roomId, userId);
    }

    private void checkListRoomDb(long roomId, long hotelId) {
        @SuppressWarnings("unchecked")
        List<Room> roomList = orderRepository.convertContentFromPathToList("/Users/macbook/Documents/DB final project/RoomDb.txt");
        int count = 0;

        for (Room room : roomList) {
            if (room.getId() == roomId && room.getHotel().getId() == hotelId) {
                count++;
                break;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("This room don't have in RoomDb.");
        }
    }

    public void checkLoginThisUserInUserLoginDb(long userId) throws LoginException {
        @SuppressWarnings("unchecked")
        List<User> list = userRepository.convertContentFromPathToList("/Users/macbook/Documents/DB final project/UserLoginDb.txt");
        for (User user : list) {
            if (user.getId() != userId) {
                throw new LoginException("User with id: " + userId + " not login" );
        }
        }

    }
}

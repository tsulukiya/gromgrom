package lesson35.repository;


import lesson35.model.Order;
import lesson35.model.Room;

import java.util.List;
import java.util.Random;

public class OrderRepository extends ShareRepository {
    RoomRepository roomRepository = new RoomRepository();
    UserRepository userRepository = new UserRepository();

    // 1. Найти комнату по заданным параметрам в HotelDb
    // 2. Проверить, свободна ли она с dateFrom
    // 3. Если свободна, то создаем обект Order и вносим в OrderDb
    // 4. Меняем значение dateAvailable в RoomDb.

    public void bookRoom(long roomId, long userId, long hotelId) {
        @SuppressWarnings("unchecked")
        List<Room> roomList = convertContentFromPathToList("/Users/macbook/Documents/DB final project/RoomDb.txt");

        for (Room room : roomList) {
            if (room.getId() == roomId && room.getHotel().getId() == hotelId) {

            }
        }
    }

    public void cancelReservation(long roomId, long userId) {
        // TODO: 22.01.2019 Logic in OrderDb.txt
    }


    @Override
    Object initObject(String[] mas) {
        return null;
    }
}

package lesson35.services;

import lesson35.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    public void bookRoom(long roomId, long userId) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        orderRepository.bookRoom(roomId, userId);
    }

    public void cancelReservation(long roomId, long userId) {
        // TODO: 22.01.2019 VALIDATE LOGIC
        orderRepository.cancelReservation(roomId, userId);
    }
}

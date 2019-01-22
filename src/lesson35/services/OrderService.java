package lesson35.services;

import lesson35.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    public void bookRoom(long roomId, long userId) {
        orderRepository.bookRoom(roomId, userId);
    }

    public void cancelReservation(long roomId, long userId) {
        orderRepository.cancelReservation(roomId, userId);
    }
}

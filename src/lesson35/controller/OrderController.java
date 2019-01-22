package lesson35.controller;

import lesson35.services.OrderService;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId) {
        orderService.bookRoom(roomId, userId);
    }

    public void cancelReservation(long roomId, long userId) {
        orderService.cancelReservation(roomId, userId);
    }
}

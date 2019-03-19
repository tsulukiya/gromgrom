package lesson35.controller;

import lesson35.services.OrderService;

import javax.security.auth.login.LoginException;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId, long hotelId) throws LoginException {
        orderService.bookRoom(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) {
        orderService.cancelReservation(roomId, userId);
    }
}

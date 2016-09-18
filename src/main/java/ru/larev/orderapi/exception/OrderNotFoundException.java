package ru.larev.orderapi.exception;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
public class OrderNotFoundException extends Exception {
    private final long orderId;

    public OrderNotFoundException(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }
}

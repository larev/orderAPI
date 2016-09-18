package ru.larev.orderapi.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResult {
    private boolean status;
    private Long orderId;
    private String message;

    private OrderResult() {
    }

    private OrderResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    private OrderResult(boolean status, String message, long orderId) {
        this(status, message);
        this.orderId = orderId;
    }

    public static OrderResult success(long orderId, String message) {
        return new OrderResult(true, message, orderId);
    }

    public static OrderResult fail(String message) {
        return new OrderResult(false, message);
    }

    public boolean isStatus() {
        return status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getMessage() {
        return message;
    }

}

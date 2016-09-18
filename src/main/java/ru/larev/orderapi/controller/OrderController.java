package ru.larev.orderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.larev.orderapi.entity.Order;
import ru.larev.orderapi.entity.User;
import ru.larev.orderapi.exception.OrderNotFoundException;
import ru.larev.orderapi.payload.OrderResult;
import ru.larev.orderapi.service.OrderService;

import java.util.List;
import java.util.Set;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public OrderResult createOrder(Authentication authentication, @RequestParam Set<Long> productIds) {
        User user = (User) authentication.getPrincipal();
        return OrderResult.success(orderService.addOrder(user, productIds), "OK");
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public Order order(@PathVariable long orderId) throws OrderNotFoundException {
        return orderService.getOrder(orderId);
    }

    @RequestMapping(value = "/orders/{page}/{size}", method = RequestMethod.GET)
    public List<Order> orders(Authentication authentication, @PathVariable int page, @PathVariable int size) {
        User user = (User) authentication.getPrincipal();
        return orderService.getOrdersByUser(user, new PageRequest(page, size));
    }

    @ExceptionHandler
    public OrderResult orderNotFound(OrderNotFoundException e) {
        return OrderResult.fail("Order " + e.getOrderId() + " not found");
    }
}

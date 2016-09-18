package ru.larev.orderapi.service;

import org.springframework.data.domain.Pageable;
import ru.larev.orderapi.entity.Order;
import ru.larev.orderapi.entity.User;
import ru.larev.orderapi.exception.OrderNotFoundException;

import java.util.List;
import java.util.Set;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
public interface OrderService {
    long addOrder(User user, Set<Long> productArticles);

    Order getOrder(long orderId) throws OrderNotFoundException;

    List<Order> getOrdersByUser(User user, Pageable pageable);
}

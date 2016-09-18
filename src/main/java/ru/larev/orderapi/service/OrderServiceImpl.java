package ru.larev.orderapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.larev.orderapi.entity.Order;
import ru.larev.orderapi.entity.Product;
import ru.larev.orderapi.entity.User;
import ru.larev.orderapi.exception.OrderNotFoundException;
import ru.larev.orderapi.repository.OrderRepository;
import ru.larev.orderapi.repository.ProductRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public long addOrder(User user, Set<Long> productArticles) {
        Order order = new Order();
        order.setUser(user);
        Iterable<Product> existingProducts = productRepository.findAll(productArticles);
        Set<Product> products = order.getProducts();
        existingProducts.forEach(products::add);
        Order save = orderRepository.save(order);
        return save.getId();
    }

    @Override
    public List<Order> getOrdersByUser(User user, Pageable pageable) {
        return orderRepository.findByUser(user, pageable);
    }


    @Override
    public Order getOrder(long orderId) throws OrderNotFoundException {
        Order order = orderRepository.findOne(orderId);
        if (order == null) throw new OrderNotFoundException(orderId);
        return order;
    }
}

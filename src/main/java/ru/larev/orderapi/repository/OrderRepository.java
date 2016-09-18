package ru.larev.orderapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.larev.orderapi.entity.Order;
import ru.larev.orderapi.entity.User;

import java.util.List;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUser(User user, Pageable pageable);
}

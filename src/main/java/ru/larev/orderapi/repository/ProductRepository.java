package ru.larev.orderapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.larev.orderapi.entity.Product;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}

package ru.larev.orderapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.larev.orderapi.entity.User;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}

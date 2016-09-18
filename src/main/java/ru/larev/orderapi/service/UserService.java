package ru.larev.orderapi.service;

import ru.larev.orderapi.entity.User;
import ru.larev.orderapi.exception.UserAllreadyExistException;
import ru.larev.orderapi.exception.UserNotFoundException;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
public interface UserService {
    User getUser(String name) throws UserNotFoundException;

    User addUser(String name, String password) throws UserAllreadyExistException;
}

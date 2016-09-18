package ru.larev.orderapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.larev.orderapi.entity.User;
import ru.larev.orderapi.exception.UserAllreadyExistException;
import ru.larev.orderapi.exception.UserNotFoundException;
import ru.larev.orderapi.repository.UserRepository;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User getUser(String name) throws UserNotFoundException {
        User user = userRepository.findOne(name);
        if (user == null) throw new UserNotFoundException(name);
        return user;
    }

    @Override
    public User addUser(String name, String password) throws UserAllreadyExistException {
        if (userRepository.exists(name)) throw new UserAllreadyExistException(name);
        User user = new User();
        user.setName(name);
        user.setPasshash(encoder.encode(password));
        return userRepository.save(user);
    }
}

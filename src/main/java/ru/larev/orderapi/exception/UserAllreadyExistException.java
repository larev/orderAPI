package ru.larev.orderapi.exception;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
public class UserAllreadyExistException extends Throwable {
    private final String name;

    public UserAllreadyExistException(String name) {
        this.name = name;
    }
}

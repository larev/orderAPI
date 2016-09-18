package ru.larev.orderapi.exception;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
public class UserNotFoundException extends Throwable {
    private final String name;

    public UserNotFoundException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

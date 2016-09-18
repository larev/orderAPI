package ru.larev.orderapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    private String name;

    private String passhash;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }
}

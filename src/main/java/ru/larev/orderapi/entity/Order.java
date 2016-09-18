package ru.larev.orderapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Fetch(FetchMode.JOIN)
    @ManyToMany
    private Set<Product> products = new HashSet<>();

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public long getId() {
        return id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

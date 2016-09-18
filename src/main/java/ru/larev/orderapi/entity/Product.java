package ru.larev.orderapi.entity;

import javax.persistence.*;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long article;

    @Column(nullable = false)
    private String name;

    public long getArticle() {
        return article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

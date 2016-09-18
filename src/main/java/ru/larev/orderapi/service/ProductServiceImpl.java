package ru.larev.orderapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.larev.orderapi.entity.Product;
import ru.larev.orderapi.repository.ProductRepository;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}

package com.company.services.impl;

import com.company.domains.Product;
import com.company.repositories.ProductRepository;
import com.company.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by petenguy1 on 12/22/2016.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveProductList(Iterable<Product> productIterable) {
        return productRepository.save(productIterable);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }


}

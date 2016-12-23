package com.company.services;

import com.company.domains.Product;
import org.springframework.stereotype.Service;

/**
 * Created by petenguy1 on 12/22/2016.
 */
public interface ProductService {

    Iterable<Product> listAllProducts();

    Product getProductById(Long id);

    Product saveProduct(Product product);

    Iterable<Product> saveProductList(Iterable<Product> productIterable);

    void deleteProduct(Long id);

}

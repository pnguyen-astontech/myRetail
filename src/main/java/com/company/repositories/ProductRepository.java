package com.company.repositories;

import com.company.domains.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by petenguy1 on 12/22/2016.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}

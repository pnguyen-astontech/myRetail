package com.company.rest;

import com.company.domains.CurrentPrice;
import com.company.domains.Product;
import com.company.repositories.CurrentPriceRepository;
import com.company.repositories.mongo.MongoCurrentPriceRepository;
import com.company.services.ExternalProductService;
import com.company.services.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by petenguy1 on 12/22/2016.
 */
@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private MongoCurrentPriceRepository mongoCurrentPriceRepository;

    @Autowired
    private ExternalProductService externalProductService;

    @Autowired
    private ProductService productService;

    // GET BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getById(@PathVariable long id) {
        Product product = productService.getProductById(id);

        // Set current price from MongoDb
        product.setCurrent_price(mongoCurrentPriceRepository.findOne(product.getCurrent_price().getId()));

        // Set product name from external api call using "general_description"
        product.setName(externalProductService.findProductName(Long.toString(id)));
        return product;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product updateProduct (@PathVariable long id, @RequestBody Product product) {

        // Save current price to MongoDb
        CurrentPrice currentPrice = product.getCurrent_price();
        mongoCurrentPriceRepository.save(currentPrice);

        // Set product name from external api call using "general_description"
        product.setName(externalProductService.findProductName(Long.toString(id)));

        return product;
    }
}
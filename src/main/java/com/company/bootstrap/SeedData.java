package com.company.bootstrap;

import com.company.domains.CurrentPrice;
import com.company.domains.Product;
import com.company.repositories.CurrentPriceRepository;
import com.company.repositories.ProductRepository;
import com.company.repositories.mongo.MongoCurrentPriceRepository;
import com.company.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by petenguy1 on 12/22/2016.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CurrentPriceRepository currentPriceRepository;

    @Autowired
    private MongoCurrentPriceRepository mongoCurrentPriceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateData();
    }

    private void generateData() {

        CurrentPrice currentPrice = new CurrentPrice();
        currentPrice.setValue(13.49);
        currentPrice.setCurrency_code("USD");
        currentPriceRepository.save(currentPrice);
        mongoCurrentPriceRepository.save(currentPrice);

        Product product = new Product((long)13860428, "The Big Lebowski (Blu-ray) (Widescreen)", currentPrice);
        productRepository.save(product);

        CurrentPrice currentPrice1 = new CurrentPrice();
        currentPrice1.setValue(299.99);
        currentPrice1.setCurrency_code("USD");
        currentPriceRepository.save(currentPrice1);
        mongoCurrentPriceRepository.save(currentPrice1);

        Product product1 = new Product((long)16696652, "Beats Solo 2 Wireless Headphone Black", currentPrice1);
        productRepository.save(product1);


    }


}

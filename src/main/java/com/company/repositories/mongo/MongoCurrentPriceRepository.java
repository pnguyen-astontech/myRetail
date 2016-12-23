package com.company.repositories.mongo;

import com.company.domains.CurrentPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by petenguy1 on 12/22/2016.
 */
public interface MongoCurrentPriceRepository extends MongoRepository<CurrentPrice, Long> {
}

package com.company.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by petenguy1 on 12/22/2016.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.company.domains"})
@EnableJpaRepositories(basePackages = {"com.company.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}


package com.pluralsight.security.repository;

import com.pluralsight.security.entity.Portfolio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortfolioRepository extends MongoRepository<Portfolio, String> {

    Portfolio findByUsername(String username);
}

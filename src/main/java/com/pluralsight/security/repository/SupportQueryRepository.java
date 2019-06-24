package com.pluralsight.security.repository;

import com.pluralsight.security.entity.SupportQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupportQueryRepository extends MongoRepository<SupportQuery, String> {

    List<SupportQuery> findByUsername(String username);

}

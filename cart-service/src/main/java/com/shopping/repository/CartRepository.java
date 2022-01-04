package com.shopping.repository;


import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.model.CartDetails;


public interface CartRepository extends MongoRepository<CartDetails, Integer> {


}
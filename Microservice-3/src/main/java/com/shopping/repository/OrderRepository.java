package com.shopping.repository;

import com.shopping.model.OrderModel;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends MongoRepository<OrderModel, Integer>{

}
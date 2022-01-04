package com.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.models.Admin;

public interface AdminRepository extends MongoRepository <Admin, Integer> {
	Admin findByaEmail(String Email);


}

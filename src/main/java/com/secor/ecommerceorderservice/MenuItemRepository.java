package com.secor.ecommerceorderservice;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
    MenuItem findByDishid(String dishid);
}

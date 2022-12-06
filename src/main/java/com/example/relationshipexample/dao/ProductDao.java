package com.example.relationshipexample.dao;

import com.example.relationshipexample.ds.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Integer> {
}

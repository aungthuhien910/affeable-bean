package com.example.relationshipexample.dao;

import com.example.relationshipexample.ds.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category,Integer> {
}

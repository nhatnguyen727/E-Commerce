package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}

package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Size;

@Repository
public interface SizeRepository extends CrudRepository<Size, Integer> {

}

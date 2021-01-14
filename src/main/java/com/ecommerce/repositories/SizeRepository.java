package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Models.Size;

@Repository
public interface SizeRepository extends CrudRepository<Size, Integer>{

}

package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Models.OrdersDetail;
@Repository
public interface OrdDetailRepository extends CrudRepository<OrdersDetail, Integer>{
	
}

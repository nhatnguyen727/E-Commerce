package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.Models.Size;

public interface SizeService {

	List<Size> findAllById(Iterable<Integer> ids);

	Iterable<Size> findAll();

	Optional<Size> findById(Integer id);

	Size save(Size entity);

}

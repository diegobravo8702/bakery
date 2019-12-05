package com.bravo.bakery.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bravo.bakery.persistence.entities.ProductEntity;

public interface ProductServiceInterface {

	public Page<ProductEntity> productFindAll(Pageable pageable);

}
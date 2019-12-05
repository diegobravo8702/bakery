package com.bravo.bakery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bravo.bakery.persistence.entities.ProductEntity;
import com.bravo.bakery.repository.CategoryRepository;
import com.bravo.bakery.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {

//	@Autowired
//	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Page<ProductEntity> productFindAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

}

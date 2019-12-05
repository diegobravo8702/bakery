package com.bravo.bakery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bravo.bakery.persistence.entities.CategoryEntity;
import com.bravo.bakery.repository.CategoryRepository;

@Service
public class CategoryService implements CategoryServiceInterface {

	@Autowired
	private CategoryRepository categoryRepository;

//	@Autowired
//	private ProductRepository productRepository;

	@Override
	public Page<CategoryEntity> categoryFindAll(Pageable pageable) {
		Page<CategoryEntity> res = categoryRepository.findAll(pageable);
		return categoryRepository.findAll(pageable);
	}

}

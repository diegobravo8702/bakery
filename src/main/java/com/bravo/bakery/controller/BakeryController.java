package com.bravo.bakery.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bravo.bakery.persistence.entities.CategoryEntity;
import com.bravo.bakery.persistence.entities.ProductEntity;
import com.bravo.bakery.repository.CategoryRepository;
import com.bravo.bakery.repository.ProductRepository;

@RestController
public class BakeryController {

	Logger log = Logger.getLogger(BakeryController.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/api/v1/category/all")
	public List<CategoryEntity> getAllCategories() {
		log.debug("getAllCategories");
		return (List<CategoryEntity>) categoryRepository.findAll();
	}

	@GetMapping("/api/v1/product/all")
	public List<ProductEntity> getAllProducts() {
		log.debug("getAllProducts");
		return (List<ProductEntity>) productRepository.findAll();
	}
}

package com.bravo.bakery.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	/**
	 * FIND CATEGORY
	 */
	@GetMapping("/api/v1/category/{id}")
	public CategoryEntity categoryFind(@PathVariable String id) {
		log.debug("buscando categoria");
		Long id_category = Long.parseLong(id);
		return categoryRepository.findById(id_category).orElse(null);
	}

	/**
	 * CREATE/UPDATE CATEGORY
	 */
	@PostMapping("/api/v1/category")
	public CategoryEntity categoryCreate(@RequestBody CategoryEntity category) {
		log.debug("guardando categoria");
		category = categoryRepository.save(category);
		return category;
	}

	/**
	 * DELETE CATEGORY
	 */
	@DeleteMapping("/api/v1/category/{id}")
	public void categoryDelete(@PathVariable String id) {
		log.debug("eliminando categoria");
		Long id_category = Long.parseLong(id);
		categoryRepository.deleteById(id_category);
	}

	/**
	 * FIND PRODUCT
	 */
	@GetMapping("/api/v1/product/{id}")
	public ProductEntity productFind(@PathVariable String id) {
		log.debug("buscando producto");
		Long id_product = Long.parseLong(id);
		return productRepository.findById(id_product).orElse(null);
	}

	/**
	 * CREATE/UPDATE PRODUCT
	 */
	@PostMapping("/api/v1/product")
	public ProductEntity productCreate(@RequestBody ProductEntity product) {
		log.debug("creating/updating product");
		product = productRepository.save(product);
		return product;
	}

	/**
	 * DELETE PRODUCT
	 */
	@DeleteMapping("/api/v1/product/{id}")
	public void productDelete(@PathVariable String id) {
		log.debug("deleting product");
		Long id_product = Long.parseLong(id);
		productRepository.deleteById(id_product);
	}
}

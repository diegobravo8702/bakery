package com.bravo.bakery.controller;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.bravo.bakery.persistence.entities.CategoryEntity;
import com.bravo.bakery.persistence.entities.ProductEntity;
import com.bravo.bakery.repository.CategoryRepository;
import com.bravo.bakery.repository.ProductRepository;
import com.bravo.bakery.service.CategoryServiceInterface;
import com.bravo.bakery.service.ProductServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class BakeryControllerV2 {

	Logger log = Logger.getLogger(BakeryControllerV2.class);

	/**
	 * V2
	 */

	@Autowired
	private EntityLinks links;

	@Autowired
	private ProductServiceInterface productService;

	@Autowired
	private CategoryServiceInterface categoryService;

	/**
	 * V1 Get All Categories
	 */

	@GetMapping(value = "/api/v2/categories", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PagedResources<CategoryEntity>> categories(Pageable pageable, PagedResourcesAssembler<CategoryEntity> assembler) {

		log.debug("Consultando las categorias con la api V2");
		log.debug(pageable.toString());

		Page<CategoryEntity> categories = categoryService.categoryFindAll(pageable);

		if (categories == null || categories.isEmpty()) {
			log.debug("Empty or null list");
		} else {
			log.debug("Categories len: " + categories.getSize());
		}

		PagedResources<Resource<CategoryEntity>> pr = assembler.toResource(categories, linkTo(BakeryControllerV2.class).slash("/api/v2/categories").withSelfRel());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Link", createLinkHeaderCategory(pr));

		return new ResponseEntity(assembler.toResource(categories, linkTo(BakeryControllerV2.class).slash("/api/v2/categories").withSelfRel()), responseHeaders, HttpStatus.OK);
	}

	/**
	 * V1 Get All Products
	 */

	@GetMapping(value = "/api/v2/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PagedResources<ProductEntity>> products(Pageable pageable, PagedResourcesAssembler<ProductEntity> assembler) {

		log.debug("Consultando los productos con la api V2");
		log.debug(pageable.toString());

		Page<ProductEntity> products = productService.productFindAll(pageable);

		if (products == null || products.isEmpty()) {
			log.debug("Empty or null list");
		} else {
			log.debug("Products len: " + products.getSize());
		}

		//PagedResources<Resource<ProductEntity>> pr = assembler.toResource(products, linkTo(BakeryControllerV2.class).slash("/api/v2/products").withSelfRel());
		PagedResources<Resource<ProductEntity>> pr = assembler.toResource(products, linkTo(BakeryControllerV2.class).slash("/api/v2/products").withSelfRel());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Link", createLinkHeaderProduct(pr));

		return new ResponseEntity(assembler.toResource(products, linkTo(BakeryControllerV2.class).slash("/api/v2/products").withSelfRel()), responseHeaders, HttpStatus.OK);
	}

//	/**
//	 * V1 FIND CATEGORY
//	 */
//	@GetMapping("/api/v1/category/{id}")
//	public ResponseEntity<CategoryEntity> categoryFind(@PathVariable String id) {
//		log.debug("buscando categoria");
//		Long id_category = Long.parseLong(id);
//		return ResponseEntity.ok().body(categoryRepository.findById(id_category).orElse(null));
//	}
//
//	/**
//	 * V1 CREATE/UPDATE CATEGORY
//	 */
//	@PostMapping("/api/v1/category")
//	public CategoryEntity categoryCreate(@RequestBody CategoryEntity category) {
//		log.debug("guardando categoria");
//		category = categoryRepository.save(category);
//		return category;
//	}
//
//	/**
//	 * V1 DELETE CATEGORY
//	 */
//	@DeleteMapping("/api/v1/category/{id}")
//	public void categoryDelete(@PathVariable String id) {
//		log.debug("eliminando categoria");
//		Long id_category = Long.parseLong(id);
//		categoryRepository.deleteById(id_category);
//	}
//
//	/**
//	 * V1 FIND PRODUCT
//	 */
//	@GetMapping("/api/v1/product/{id}")
//	public ProductEntity productFind(@PathVariable String id) {
//		log.debug("buscando producto");
//		Long id_product = Long.parseLong(id);
//		return productRepository.findById(id_product).orElse(null);
//	}
//
//	/**
//	 * V1 CREATE/UPDATE PRODUCT
//	 */
//	@PostMapping("/api/v1/product")
//	public ProductEntity productCreate(@RequestBody ProductEntity product) {
//		log.debug("creating/updating product");
//		product = productRepository.save(product);
//		return product;
//	}
//
//	/**
//	 * V1 DELETE PRODUCT
//	 */
//	@DeleteMapping("/api/v1/product/{id}")
//	public void productDelete(@PathVariable String id) {
//		log.debug("deleting product");
//		Long id_product = Long.parseLong(id);
//		productRepository.deleteById(id_product);
//	}

	private String createLinkHeaderCategory(PagedResources<Resource<CategoryEntity>> pr) {
		final StringBuilder linkHeader = new StringBuilder();
		try {
			linkHeader.append(buildLinkHeader(pr.getLinks("first").get(0).getHref(), "first"));
		} catch (Exception e) {
			log.debug("##### PAILA 1");
			log.error(e.getMessage(), e);
		}
		linkHeader.append(", ");
		try {
			linkHeader.append(buildLinkHeader(pr.getLinks("next").get(0).getHref(), "next"));
		} catch (Exception e) {
			log.debug("##### PAILA 2");
			log.error(e.getMessage(), e);
		}
		return linkHeader.toString();
	}
	private String createLinkHeaderProduct(PagedResources<Resource<ProductEntity>> pr) {
		final StringBuilder linkHeader = new StringBuilder();
		try {
			linkHeader.append(buildLinkHeader(pr.getLinks("first").get(0).getHref(), "first"));
		} catch (Exception e) {
			log.debug("##### PAILA 1");
			log.error(e.getMessage(), e);
		}
		linkHeader.append(", ");
		try {
			linkHeader.append(buildLinkHeader(pr.getLinks("next").get(0).getHref(), "next"));
		} catch (Exception e) {
			log.debug("##### PAILA 2");
			log.error(e.getMessage(), e);
		}
		return linkHeader.toString();
	}

	public static String buildLinkHeader(final String uri, final String rel) {
		return "<" + uri + ">; rel=\"" + rel + "\"";
	}

}

package com.bravo.bakery.page;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.bravo.bakery.persistence.entities.CategoryEntity;

public class CategoryPage extends ResourceSupport {

	List<CategoryEntity> categories;
	private int pageNumber;
	private int size;
	private int totalPages;
	private int totalElements;

	public CategoryPage(List<CategoryEntity> categories, int pageNumber, int size, int totalPages, int totalElements) {
		this.categories = categories;
		this.pageNumber = pageNumber;
		this.size = size;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
	}

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getSize() {
		return size;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotalElements() {
		return totalElements;
	}
}
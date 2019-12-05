package com.bravo.bakery.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bravo.bakery.persistence.entities.CategoryEntity;

public interface CategoryServiceInterface {

	public Page<CategoryEntity> categoryFindAll(Pageable pageable);

}

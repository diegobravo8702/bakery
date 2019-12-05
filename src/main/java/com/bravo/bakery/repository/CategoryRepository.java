package com.bravo.bakery.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bravo.bakery.persistence.entities.CategoryEntity;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<CategoryEntity, Long> {

}

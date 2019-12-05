package com.bravo.bakery.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bravo.bakery.currency.CurrencyRate;
import com.bravo.bakery.persistence.entities.ProductEntity;
import com.bravo.bakery.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {
	private static final Logger log = Logger.getLogger(ProductService.class);

//	@Autowired
//	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CurrencyRate currencyRate;

	@Override
	public Page<ProductEntity> productFindAll(Pageable pageable) {
		Page<ProductEntity> products = productRepository.findAll(pageable);
		for (ProductEntity p : products) {
			// log.debug(p.getName() + " price: USD-> " + p.getPrice() + " COP -> " + currencyRate.convert(p.getPrice()));
			p.setPriceCOP(currencyRate.convert(p.getPrice()));
		}
		return products;
	}

}

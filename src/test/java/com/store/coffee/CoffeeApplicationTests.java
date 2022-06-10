package com.store.coffee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.store.coffee.Repository.ProductRepository;
import com.store.coffee.models.Product;

@Transactional
@SpringBootTest
class CoffeeApplicationTests {
	
	@Test
	void ProductModelTest() {
		Product product = getProduct();
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getFlavour());
		System.out.println(product.getType());
		System.out.println(product.getDescription());
		System.out.println(product.getPrice());
		
	}
	
	@Autowired 
	private ProductRepository repository;
	
	@Test
	public void testRepositoryAndDbLoading() {
		List<Product> result = new ArrayList<>();
		repository.findAll().forEach(e -> result.add(e));
		result.forEach(e -> System.out.println(e.getName()));
		assertEquals(result.size(),12);
	}
	

	
	private Product getProduct() {
		Product product = new Product("name","flavour","grind","type","description",34);
		return product;
	}
	
}

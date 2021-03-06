package com.store.coffee.DbLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.store.coffee.Repository.ProductRepository;
import com.store.coffee.models.Product;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(ProductRepository repository) {
		
		repository.save(new Product("Original - Fine Grind","original","fine","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",100));
		repository.save(new Product("Hazelnut - Fine Grind","hazelnut","fine","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",101));
		repository.save(new Product("Caramel - Fine Grind","caramel","fine","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",102));
		repository.save(new Product("Vanilla - Fine Grind","vanilla","fine","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",103));
		repository.save(new Product("Original - Medium Grind","original","medium","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",104));
		repository.save(new Product("Hazelnut - Medium Grind","hazelnut","medium","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",105));
		repository.save(new Product("Caramel - Medium Grind","caramel","medium","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",106));
		repository.save(new Product("Vanilla - Medium Grind","vanilla","medium","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",107));
		repository.save(new Product("Original - Coarse Grind","original","coarse","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",108));
		repository.save(new Product("Hazelnut - Coarse Grind","hazelnut","coarse","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",109));
		repository.save(new Product("Caramel - Coarse Grind","caramel","coarse","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",110));
		repository.save(new Product("Vanilla - Coarse Grind","vanilla","coarse","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",111));
		
		
		return args-> {
			log.info("Preloading data !");
		};
	}
	
}

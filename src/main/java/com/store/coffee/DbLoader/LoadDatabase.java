package com.store.coffee.DbLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.store.coffee.models.Product;
import com.store.coffee.repository.ProductRepository;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(ProductRepository repository) {
		
		repository.save(new Product(1,"Original - Fine Grind","original","fine","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",100));
		repository.save(new Product(2,"Hazelnut - Fine Grind","hazelnut","fine","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",101));
		repository.save(new Product(3,"Caramel - Fine Grind","caramel","fine","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",102));
		repository.save(new Product(4,"Vanilla - Fine Grind","vanilla","fine","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",103));
		repository.save(new Product(5,"Original - Medium Grind","original","medium","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",104));
		repository.save(new Product(6,"Hazelnut - Medium Grind","hazelnut","medium","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",105));
		repository.save(new Product(7,"Caramel - Medium Grind","caramel","medium","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",106));
		repository.save(new Product(8,"Vanilla - Medium Grind","vanilla","medium","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",107));
		repository.save(new Product(9,"Original - Coarse Grind","original","coarse","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",108));
		repository.save(new Product(10,"Hazelnut - Coarse Grind","hazelnut","coarse","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",109));
		repository.save(new Product(11,"Caramel - Coarse Grind","caramel","coarse","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",110));
		repository.save(new Product(12,"Vanilla - Coarse Grind","vanilla","coarse","arabiata","In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",111));
		
		
		return args-> {
			log.info("Preloading data !");
		};
	}
	
}

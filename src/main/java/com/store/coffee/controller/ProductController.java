package com.store.coffee.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.coffee.exception.ProductExistsException;
import com.store.coffee.models.Product;
import com.store.coffee.repository.ProductRepository;

@RestController
public class ProductController {

	private final ProductRepository repository;
	
	
	
	ProductController(ProductRepository repository){
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "https://angular-learning-project.vercel.app/")
	@GetMapping("/products")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	List<Product> all(){
		return repository.findAll();
	}
	
	@CrossOrigin(origins = "https://angular-learning-project.vercel.app/")
	@GetMapping("/products/")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	Optional<Product> searchById(@RequestParam long id){
		return repository.findById(id);
	}
	
	@CrossOrigin(origins = "https://angular-learning-project.vercel.app/")
	@GetMapping("/products/search/")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	List<Product> searchByName(@RequestParam String name){
		List<Product> products = repository.findAll();
		List<Product> result = new ArrayList<Product>();
		
		products.forEach(p -> {
			if(p.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(p);
			}
		});
		
		
		return result;
	}
	
	@CrossOrigin(origins = "https://angular-learning-project.vercel.app/")
	@GetMapping("/flavours")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	List<String> getFlavours(){
		List<Product> products = repository.findAll();
		Set<String> uniqueFlavours = new HashSet<String>();
		products.forEach(p -> {
			uniqueFlavours.add(p.getFlavour());
		});

		List<String> flavours = new ArrayList<String>(uniqueFlavours);
		return flavours;
	}
	
	@CrossOrigin(origins = "https://angular-learning-project.vercel.app/")
	@GetMapping("/grinds")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	List<String> getGrinds(){
		List<Product> products = repository.findAll();
		Set<String> uniqueGrinds = new HashSet<String>();
		products.forEach(p -> {
			uniqueGrinds.add(p.getGrind());
		});

		List<String> grinds = new ArrayList<String>(uniqueGrinds);
		return grinds;
	}
	
	@CrossOrigin(origins = "https://angular-learning-project.vercel.app/")
	@PostMapping("/products")
	@PreAuthorize("hasRole('ADMIN')")
	Product newProduct(@RequestBody Product newProduct) {
		newProduct.setFlavour(newProduct.getFlavour().toLowerCase());
		newProduct.setGrind(newProduct.getGrind().toLowerCase());
		
		boolean existsFlag=false;
		
		// search if grind and flavour already exist. If exists, return 
		List<Product> products = repository.findAll();
		for(Product p:products) {
			if(p.getFlavour().equals(newProduct.getFlavour()) && p.getGrind().equals(newProduct.getGrind())) {
        		existsFlag = true;
        	}
		}
		
		
		if(existsFlag) {
			throw new ProductExistsException();
		}
		return repository.save(newProduct);
	}
	
	@CrossOrigin(origins = "https://angular-learning-project.vercel.app/")
	@PutMapping("/products/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	Product replaceProduct(@RequestBody Product newProduct, @PathVariable long id) {
		return repository.findById(id).map((product) -> {
					product.setName(newProduct.getName());
					product.setFlavour(newProduct.getFlavour());
					product.setGrind(newProduct.getGrind());
					product.setType(newProduct.getType());
					product.setDescription(newProduct.getDescription());
					product.setPrice(newProduct.getPrice());
					return repository.save(product);
				})
				.orElseGet(() -> {
					newProduct.setId(id);
					return repository.save(newProduct);
				});
	}
	
	@CrossOrigin(origins = "https://angular-learning-project.vercel.app/")
	@DeleteMapping("products/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	void deleteProduct(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}

//{
//    "name": "New Coffee",
//    "flavour": "new flavour",
//    "grind": "new grind",
//    "type": "arabiata",
//    "description": "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.",
//    "price": 137
//}

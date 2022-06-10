package com.store.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.mockito.InjectMocks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import com.store.coffee.Repository.ProductRepository;
import com.store.coffee.controller.ProductController;

@WebMvcTest(ProductController.class)
public class ControllerTests {
	
	@Autowired
	protected MockMvc mvc;
	
	@Autowired 
	private ProductRepository repository;
	
	@Test
	public void getAllEmployeesAPI() throws Exception 
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/products")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.products").exists())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.products[*].productsId").isNotEmpty());
	  
	  
	}
}

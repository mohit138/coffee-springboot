package com.store.coffee.models;



import org.springframework.data.annotation.Id;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
//@Table(name="products")
//@EntityListeners(AuditingEntityListener.class)
@Document(collection="products")
public class Product {
	
	public Product() {
		
	}
	
	public Product(long id,String name, String flavour, String grind, String type, String description, long price) {
		this.id = id;
		this.name = name;
		this.flavour = flavour;
		this.grind = grind;
		this.type = type;
		this.description = description;
		this.price = price;
	}

	@Id
	private long id;
	
//	@Column(name="product_name", nullable=false)
	private String name;
	
//	@Column(name="product_flavour",nullable=false)
	private String flavour;
	
//	@Column(name="product_grind", nullable=false)
	private String grind;
	
//	@Column(name="product_type",nullable=false)
	private String type;
	
//	@Column(name="product_description", nullable=false)
	private String description;
	
//	@Column(name="product_price",nullable=false)
	private long price;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFlavour() {
		return flavour;
	}

	public String getGrind() {
		return grind;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public long getPrice() {
		return price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public void setGrind(String grind) {
		this.grind = grind;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
}

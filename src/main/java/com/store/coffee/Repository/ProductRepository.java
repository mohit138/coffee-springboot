package com.store.coffee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.coffee.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

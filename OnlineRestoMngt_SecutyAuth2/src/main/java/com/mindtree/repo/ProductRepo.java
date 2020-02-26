package com.mindtree.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

}

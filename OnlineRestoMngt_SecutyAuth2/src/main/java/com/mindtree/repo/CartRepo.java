package com.mindtree.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Cart;
import com.mindtree.entity.User;

@Repository
public interface CartRepo  extends JpaRepository<Cart, String> {
	
	//@Query(value ="SELECT * FROM cart h WHERE h.city=(:citi)" ,nativeQuery = true)


}

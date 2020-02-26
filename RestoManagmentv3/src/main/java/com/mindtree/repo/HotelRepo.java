package com.mindtree.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {
	
	
	@Query(value ="SELECT h.hotelname FROM hotel h WHERE h.city=(:citi)" ,nativeQuery = true)
	List<String> findResto(@Param("citi")String citi);

}

package com.mindtree.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Hotel;
import com.mindtree.entity.Tables;

@Repository
public interface TableRepo extends CrudRepository<Tables, String>  {
	@Query(value="select * from tables  where hotel_hotelid=(select hotelid from hotel where hotelname = :hotelname)",nativeQuery=true)
	public List findtables(@Param("hotelname")String hotelname);
}

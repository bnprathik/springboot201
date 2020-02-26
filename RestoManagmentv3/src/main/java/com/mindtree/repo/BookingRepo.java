package com.mindtree.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Customerdetail;


@Repository
public interface BookingRepo extends JpaRepository<Customerdetail, String>{

}

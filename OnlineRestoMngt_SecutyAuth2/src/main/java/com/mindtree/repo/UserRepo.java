package com.mindtree.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}

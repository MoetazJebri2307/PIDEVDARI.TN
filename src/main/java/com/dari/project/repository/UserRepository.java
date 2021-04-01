package com.dari.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.project.entity.Admin;
import com.dari.project.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
}

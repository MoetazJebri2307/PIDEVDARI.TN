package com.dari.project.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.project.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
	
	

}

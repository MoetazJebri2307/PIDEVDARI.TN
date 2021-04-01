package com.dari.project.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.project.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}

package com.dari.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.project.entity.Agent;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Long>{

}

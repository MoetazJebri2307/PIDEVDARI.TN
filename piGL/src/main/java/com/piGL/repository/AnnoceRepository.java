package com.piGL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piGL.entity.Annoce;


@Repository
public interface AnnoceRepository extends JpaRepository<Annoce, Long> {
	
	public List<Annoce> findByAddresse(String addresse);
	

}
